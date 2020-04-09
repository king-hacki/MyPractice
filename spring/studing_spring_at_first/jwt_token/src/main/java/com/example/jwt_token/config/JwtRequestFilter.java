package com.example.jwt_token.config;

import com.example.jwt_token.controller.JwtTokenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        logger.info("doFilterInternal method load");

        final Optional<String> jwt = getJwtFromRequest(request);
        jwt.ifPresent(token -> {
            try {
                if (jwtTokenService.validateToken(token))
                    logger.info("Valid jwt : " + token);
                    //  class WebAuthenticationDetailsSource
                        //  Implementation of AuthenticationDetailsSource which builds the details object from an HttpServletRequest object,
                        //  creating a WebAuthenticationDetails .
                    //  class WebAuthenticationDetails
                        //  A holder of selected HTTP details related to a web authentication request.
                    setSecurityContext(new WebAuthenticationDetailsSource().buildDetails(request), token);
            } catch (IllegalArgumentException e) {
                logger.error("Unable to get JWT Token or JWT Token has expired");
                //UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("anonymous", "anonymous", null);
                //SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        });

        filterChain.doFilter(request, response);
    }

    private void setSecurityContext(WebAuthenticationDetails authDetails, String token) {
        logger.info("setSecurityContext loaded ");
        logger.info("WebAuthenticationDetails in setSecurityContext " + authDetails);

        final String username = jwtTokenService.getUsernameFromToken(token);
        logger.info("username load " + username);

        final List<String> roles = jwtTokenService.getRoles(token);
        final UserDetails userDetails = new User(username, "", roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        logger.info("UserDetails for authentication : " + userDetails);

        //  class UsernamePasswordAuthenticationToken
            //  An Authentication implementation that is designed for simple presentation of a username and password.
            //  The principal and credentials should be set with an Object that provides the respective property via its Object.toString() method.
            //  The simplest such Object to use is String.

        final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        authentication.setDetails(authDetails);
        // After setting the Authentication in the context, we specify
        // that the current user is authenticated. So it passes the
        // Spring Security Configurations successfully.
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private static Optional<String> getJwtFromRequest(HttpServletRequest request) {

        Logger logger = Logger.getLogger(JwtRequestFilter.class.getName());
        logger.info("getJwtFromRequest method load");

        String bearerToken = request.getHeader(AUTHORIZATION);
        logger.info("AUTHORIZATION HEADER : " + bearerToken);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER)) {
            return Optional.of(bearerToken.substring(7));
        }
        return Optional.empty();
    }

}