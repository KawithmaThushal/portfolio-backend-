package com.example.portfolio_backend.dto;

import java.util.List;

public record PortfolioProjectDto(
        String title,
        String description,
        String imageUrl,
        String demoUrl,
        String frontendRepoUrl,
        String backendRepoUrl,
        List<String> stack
) {
}
