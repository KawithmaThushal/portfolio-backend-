package com.example.portfolio_backend.controller;

import com.example.portfolio_backend.dto.ContactRequest;
import com.example.portfolio_backend.dto.ContactResponse;
import com.example.portfolio_backend.dto.PortfolioResponse;
import com.example.portfolio_backend.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/portfolio")
    public PortfolioResponse getPortfolio() {
        return portfolioService.getPortfolio();
    }

    @PostMapping("/contact")
    public ContactResponse submitContact(@Valid @RequestBody ContactRequest request) {
        return portfolioService.saveContactMessage(request);
    }
}
