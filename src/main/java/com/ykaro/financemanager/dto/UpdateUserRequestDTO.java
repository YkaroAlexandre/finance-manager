package com.ykaro.financemanager.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDTO {
    @Size(min = 3, max = 255)
    private String name;
    @Size(min = 6)
    private String password;

}
