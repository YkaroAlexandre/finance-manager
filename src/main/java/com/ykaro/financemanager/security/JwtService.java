package com.ykaro.financemanager.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;

@Service
public class JwtService {

    @Value("${jwt.secret-key}")
    private String secretKey;
    private SecretKey secretKeyObj = Keys.hmacShaKeyFor(secretKey.getBytes());
//    private String jwtExpiration = String.valueOf((LocalDateTime.now().getMinute() +40));

    public String generateToken(String email) {
        return null;
    }
}
