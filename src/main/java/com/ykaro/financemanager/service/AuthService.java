package com.ykaro.financemanager.service;

import com.ykaro.financemanager.dto.LoginRequestDTO;
import com.ykaro.financemanager.dto.LoginResponseDTO;
import com.ykaro.financemanager.entity.UserEntity;
import com.ykaro.financemanager.exception.InvalidCredentialsException;
import com.ykaro.financemanager.repository.UserRepository;
import com.ykaro.financemanager.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponseDTO login(LoginRequestDTO dto) {
        String email = dto.getEmail().strip().toLowerCase();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new InvalidCredentialsException("Email ou senha incorretos"));
        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Email ou senha incorretos");
        }
        return LoginResponseDTO.builder()
                .token(jwtService.generateToken(email))
                .build();
    }
}
