package com.ykaro.financemanager.service;

import com.ykaro.financemanager.dto.CreateUserRequestDTO;
import com.ykaro.financemanager.dto.UserResponseDTO;
import com.ykaro.financemanager.entity.UserEntity;
import com.ykaro.financemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

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
                .created_at(LocalDateTime.now())
                .build();

        UserEntity savedUser = userRepository.save(user);

        return UserResponseDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .created_at(savedUser.getCreated_at())
                .build();
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
