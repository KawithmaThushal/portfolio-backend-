package com.example.portfolio_backend.dto;

public record HeroSectionDto(
        String availabilityLabel,
        String title,
        String subtitle,
        String description,
        String resumeUrl,
        String imageUrl,
        String imageAlt,
        String hireLabel
) {
}
