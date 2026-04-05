package com.example.portfolio_backend.dto;

import java.util.List;

public record PortfolioResponse(
        String brand,
        List<NavItemDto> navigation,
        HeroSectionDto hero,
        List<SocialLinkDto> socialLinks,
        List<StatItemDto> stats,
        List<SkillGroupDto> skills,
        List<ExperienceItemDto> experiences,
        List<PortfolioProjectDto> projects,
        ContactSectionDto contact
) {
}
