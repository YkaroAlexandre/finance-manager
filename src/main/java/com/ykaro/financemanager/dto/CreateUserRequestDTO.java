package com.ykaro.financemanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDTO {
    private String name;
    private String email;
    private String password;
}
