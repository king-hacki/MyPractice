package com.example.jwt_token.controller;

import com.example.jwt_token.JwtResponse;
import com.example.jwt_token.UserDTO;
import com.example.jwt_token.config.JwtTokenService;
import com.example.jwt_token.service.JwtUserDetailsService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin
public class JwtTokenController {

    @Autowired
    private AuthenticationManager authenticationManager;        //  interface which have one method authenticate()
    @Autowired
    private JwtTokenService jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    Logger logger = Logger.getLogger(JwtTokenController.class.getName());

    @RequestMapping(value = "/auth/token", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO authenticationRequest) throws Exception {


        logger.info("/auth/token controller loaded");
        // interface Authentication :
            // Represents the token for an authentication request or for an authenticated principal
            // once the request has been processed by the AuthenticationManager.authenticate(Authentication) method.

        final Authentication auth = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // class SecurityContextHolder :
            // This class provides a series of static methods that delegate to an instance of SecurityContextHolderStrategy.
            // The purpose of the class is to provide a convenient way to specify the strategy that should be used for a given JVM.
            // This is a JVM-wide setting, since everything in this class is static to facilitate ease of use in calling code.

        // interface SecurityContextHolderStrategy - A strategy for storing security context information against a thread.

        //  interface SecurityContext - Interface defining the minimum security information associated with the current thread of execution.
        //                              The security context is stored in a SecurityContextHolder.

        SecurityContextHolder.getContext().setAuthentication(auth);

        return ResponseEntity.ok(jwtTokenUtil.generateToken(auth));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        logger.info("/register controller loaded");
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {

            //  authenticate method --- Attempts to authenticate the passed Authentication object,
            //  returning a fully populated Authentication object (including granted authorities) if successful.

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (LockedException e) {
            throw new Exception(("USER_LOCKED"));
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}