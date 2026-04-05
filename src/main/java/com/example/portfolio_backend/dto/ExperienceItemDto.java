package com.example.portfolio_backend.dto;

import java.util.List;

public record ExperienceItemDto(
        String role,
        String company,
        String period,
        String location,
        String description,
        List<String> technologies
) {
}
