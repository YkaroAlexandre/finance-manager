package com.ykaro.financemanager.service;

import com.ykaro.financemanager.dto.CreateUserRequestDTO;
import com.ykaro.financemanager.dto.UpdateUserRequestDTO;
import com.ykaro.financemanager.dto.UserResponseDTO;
import com.ykaro.financemanager.entity.UserEntity;
import com.ykaro.financemanager.exception.ResourceNotFoundException;
import com.ykaro.financemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private UserResponseDTO toResponseDTO(UserEntity user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }


    public UserResponseDTO createUser(CreateUserRequestDTO dto) {
        UserEntity user = UserEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail().strip().toLowerCase())
                .password(dto.getPassword())
                .createdAt(LocalDateTime.now())
                .build();

        UserEntity savedUser = userRepository.save(user);

        return toResponseDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        List<UserEntity> savedUsers = userRepository.findAll();
        List<UserResponseDTO> users = new ArrayList<>();

        for (UserEntity user : savedUsers) {
            users.add(toResponseDTO(user));
        }

        return users;
    }

    public UserResponseDTO getUserById(Long id) {

        UserEntity user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));

        return toResponseDTO(user);
    }

    public void deleteUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
        userRepository.delete(user);
    }

    public UserResponseDTO updateUserById(UpdateUserRequestDTO dto, Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
        if (dto.getName() != null && !dto.getName().isBlank()){
            user.setName(dto.getName());
        }
        if (dto.getPassword() != null && !dto.getPassword().isBlank()){
            user.setPassword(dto.getPassword());
        }
        UserEntity savedUser = userRepository.save(user);

        return toResponseDTO(savedUser);
    }
}
