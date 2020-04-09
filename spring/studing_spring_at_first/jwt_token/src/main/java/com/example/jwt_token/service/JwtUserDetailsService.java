package com.example.jwt_token.service;

import com.example.jwt_token.UserDTO;
import com.example.jwt_token.controller.JwtTokenController;
import com.example.jwt_token.dao.UserRepository;
import com.example.jwt_token.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    Logger logger = Logger.getLogger(JwtUserDetailsService.class.getName());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("loadUserByUsername in JwtUserDetailsService loaded");

        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            logger.info("no register user ");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

    //save new user
    public UserEntity save(UserDTO user) {
        logger.info("save in JwtUserDetailsService loaded");
        UserEntity newUser = new UserEntity();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }
}
