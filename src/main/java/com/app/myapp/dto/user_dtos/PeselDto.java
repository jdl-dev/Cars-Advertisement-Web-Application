package com.app.myapp.dto.user_dtos;

import com.app.myapp.validation.validation.pesel_validation.UniquePesel;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PeselDto {
    @UniquePesel
    @NotNull
    private String pesel;
}
