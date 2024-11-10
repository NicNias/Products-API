package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDto(
        @NotBlank @NotNull String name,
        @NotBlank @NotNull String type,
        @NotBlank @NotNull String quantity
) {
}
