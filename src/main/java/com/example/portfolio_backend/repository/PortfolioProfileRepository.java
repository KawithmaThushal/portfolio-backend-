package com.example.portfolio_backend.repository;

import com.example.portfolio_backend.entity.PortfolioProfile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioProfileRepository extends JpaRepository<PortfolioProfile, Long> {
    Optional<PortfolioProfile> findTopByOrderByIdAsc();
}
