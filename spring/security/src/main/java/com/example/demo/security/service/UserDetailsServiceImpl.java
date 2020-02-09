package com.example.demo.security.service;

import com.example.demo.repository.UserRepository;
import lombok.SneakyThrows;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = null;
        try {
            user = (User) userRepository.findByUsername(userName).
                    orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + userName));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  UserDetailsImpl.build(user);
    }
}
