package com.example.jwt_token.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class JwtTokenService {

    Logger logger = Logger.getLogger(JwtTokenService.class.getName());

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public static final String ROLES = "ROLES";

    @Value("${jwt.secret}")
    private String secret;

    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public List<String> getRoles(String token) {
        return getClaimFromToken(token, claims -> (List) claims.get(ROLES));
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //for retrieving any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(Authentication authentication) {

        logger.info("generateToken loaded");

        /*
            OK. So JWT consist of header, payload and signature separated by (".")
                Header - typically consist of two parts:
                            1) the type of the token, which is JWT
                            2) and the signing algorithm, such as HMAC SHA256 or RSA.
                Payload - contains the claims. Claims are statements about entity(user) and
                          addition information.
                            1) Registered claims - there is a set of predefined claims(заявок) which are not
                                                   mandatory(обовязкові) but recommended, to provide a set of useful,
                                                   interoperable claims. Some of them are: iss (issuer),
                                                   exp (expiration time), sub (subject), aud (audience), and others
                            2) Public claims - These can be defined at will by those using JWTs
                            3) Private claims - These are the custom claims created to share information between
                                                parties that agree on using them
                Signature - To create the signature part you have to take the encoded header, the encoded payload,
                            a secret, the algorithm specified in the header, and sign that.
                            For example if you want to use the HMAC SHA256 algorithm,
                            the signature will be created in the following way:
                                    HMACSHA256(
                                        base64UrlEncode(header) + "." +
                                        base64UrlEncode(payload),
                                        secret)

            The output is three Base64-URL strings separated by dots that can be easily passed in HTML and HTTP environments,
            while being more compact when compared to XML-based standards such as SAML.

            Whenever the user wants to access a protected route or resource, the user agent should send the JWT,
            typically in the Authorization header using the Bearer schema.
            This can be, in certain cases, a stateless authorization mechanism.

            The server's protected routes will check for a valid JWT in the Authorization header, and if it's present,
            the user will be allowed to access protected resources. If the JWT contains the necessary data,
            the need to query the database for certain operations may be reduced, though this may not always be the case.

            site: https://jwt.io/introduction/

         */

        final Map<String, Object> claims = new HashMap<>();

        //  interface UserDetails :
            //  Implementations store user information which is later encapsulated into Authentication objects

        final UserDetails user = (UserDetails) authentication.getPrincipal();
        final List<String> roles = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        claims.put(ROLES, roles);
        return generateToken(claims, user.getUsername());
    }

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String generateToken(Map<String, Object> claims, String subject) {
        final long now = System.currentTimeMillis();
        String jwt = Jwts.builder()
                    .setClaims(claims)
                    .setSubject(subject)
                    .setIssuedAt(new Date(now))
                    .setExpiration(new Date(now + JWT_TOKEN_VALIDITY * 1000))
                    .signWith(SignatureAlgorithm.HS512, secret).compact();
        logger.info("JSON Web Token : " + jwt);
        return jwt;
    }

    //validate token
    public Boolean validateToken(String token) {
        final String username = getUsernameFromToken(token);
        return username != null && !isTokenExpired(token);
    }
}