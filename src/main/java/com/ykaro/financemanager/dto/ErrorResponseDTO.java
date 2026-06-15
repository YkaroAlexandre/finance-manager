package com.ykaro.financemanager.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponseDTO {
    private String message;
    private int status;
    private LocalDateTime timestamp;
}
