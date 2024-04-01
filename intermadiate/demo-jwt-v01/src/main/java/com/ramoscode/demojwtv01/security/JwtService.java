package com.ramoscode.demojwtv01.security;

import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.*;
import org.springframework.security.core.Authentication;

@Service
public class JwtService {
    private final JwtEncoder encoder;


    public JwtService(JwtEncoder encoderArgs) {
        this.encoder = encoderArgs;
    }

    public String getGenerateToken(Authentication authentication) {

    }
}
