package com.ykaro.financemanager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime created_at;
}
