package com.practice.ssp.dtos;

public record UserDetailsDto(
        long id,
        String firstName,
        String lastName,
        String email
) {
}
