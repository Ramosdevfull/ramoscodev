package com.ramoscode.demojwtv01.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ramoscode.demojwtv01.repository.UserRepository;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
            .map(UserAuthenticated::new)
            .orElseThrow(() -> new UsernameNotFoundException("User not found!!"));
    }
    
}
