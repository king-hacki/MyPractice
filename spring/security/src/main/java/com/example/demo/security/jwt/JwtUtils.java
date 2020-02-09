package com.example.demo.security.jwt;

import com.example.demo.security.service.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

import java.util.Date;

@Component
public class JwtUtils  {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("{jwtSecret}")
    private String jwtSecret;

    @Value("{jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken (Authentication authentication) {
        UserDetailsImpl userPrinciple = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrinciple.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken (String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid Jwt Signature " + e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid Jwt Token " + e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("Jwt token is expired " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("Jwt token is unsupported " + e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Jwt claims string is empty " + e.getMessage());
        }

        return false;
    }

}
