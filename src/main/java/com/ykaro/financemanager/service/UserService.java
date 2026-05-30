package com.ykaro.financemanager.service;

import com.ykaro.financemanager.dto.CreateUserRequestDTO;
import com.ykaro.financemanager.dto.UserResponseDTO;
import com.ykaro.financemanager.entity.UserEntity;
import com.ykaro.financemanager.repository.UserRepository;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public UserResponseDTO createUser(CreateUserRequestDTO dto) {
        UserEntity user = UserEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .createdAt(LocalDateTime.now())
                .build();

        UserEntity savedUser = userRepository.save(user);

        return UserResponseDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .createdAt(savedUser.getCreatedAt())
                .build();
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserResponseDTO getUserById(Long id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow();

        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
