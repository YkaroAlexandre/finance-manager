package com.ykaro.financemanager.service;

import com.ykaro.financemanager.entity.UserEntity;
import com.ykaro.financemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    
}
