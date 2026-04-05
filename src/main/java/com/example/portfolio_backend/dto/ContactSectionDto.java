package com.example.portfolio_backend.dto;

import java.util.List;

public record ContactSectionDto(List<ContactDetailDto> details, List<FooterHighlightDto> highlights, String footerText) {
}
