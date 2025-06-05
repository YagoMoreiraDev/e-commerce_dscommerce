package com.cloud.yagodev.ecommerce_dscommerce.domain.dtos;

import com.cloud.yagodev.ecommerce_dscommerce.domain.entities.User;

import java.time.LocalDate;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String phone,
        LocalDate birthDate)
{
    public UserResponseDTO(User entityUser) {
        this(
                entityUser.getId(),
                entityUser.getName(),
                entityUser.getEmail(),
                entityUser.getPhone(),
                entityUser.getBirthDate()
        );
    }
}
