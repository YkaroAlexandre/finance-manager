package com.ykaro.financemanager.service;

import com.ykaro.financemanager.dto.CreateUserRequestDTO;
import com.ykaro.financemanager.dto.UpdateUserRequestDTO;
import com.ykaro.financemanager.dto.UserResponseDTO;
import com.ykaro.financemanager.entity.UserEntity;
import com.ykaro.financemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public UserResponseDTO createUser(@NonNull CreateUserRequestDTO dto) {
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

    public List<UserResponseDTO> getAllUsers() {
        List<UserEntity> savedUsers = userRepository.findAll();
        List<UserResponseDTO> users = new java.util.ArrayList<>();
        for (UserEntity user : savedUsers) {
            UserResponseDTO userToSave =UserResponseDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .createdAt(user.getCreatedAt())
                    .build();
            users.add(userToSave);
        }
        return users;
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

    public void deleteUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow();
        userRepository.delete(user);
    }

    public UserResponseDTO updateUserById(UpdateUserRequestDTO dto, Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow();
        if (dto.getName() != null && !dto.getName().isBlank()){
            user.setName(dto.getName());
        }
        if (dto.getPassword() != null && !dto.getPassword().isBlank()){
            user.setPassword(dto.getPassword());
        }
        UserEntity savedUser = userRepository.save(user);

        return UserResponseDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .createdAt(savedUser.getCreatedAt())
                .build();
    }
}
