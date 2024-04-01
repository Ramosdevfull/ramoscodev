package com.ramoscode.demojwtv01.controller;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    public String autenticate() {
        return "token";
    }
}
