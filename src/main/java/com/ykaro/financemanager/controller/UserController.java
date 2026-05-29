package com.ykaro.financemanager.controller;

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
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
}
