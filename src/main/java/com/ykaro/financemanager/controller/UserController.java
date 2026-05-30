package com.ykaro.financemanager.controller;

import com.ykaro.financemanager.dto.CreateUserRequestDTO;
import com.ykaro.financemanager.dto.UserResponseDTO;
import com.ykaro.financemanager.entity.UserEntity;
import com.ykaro.financemanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponseDTO createUser(@RequestBody CreateUserRequestDTO dto){
        return userService.createUser(dto);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
