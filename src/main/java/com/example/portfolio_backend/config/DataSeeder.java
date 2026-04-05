package com.example.portfolio_backend.config;

import com.example.portfolio_backend.entity.PortfolioProfile;
import com.example.portfolio_backend.repository.PortfolioProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final PortfolioProfileRepository portfolioProfileRepository;

    public DataSeeder(PortfolioProfileRepository portfolioProfileRepository) {
        this.portfolioProfileRepository = portfolioProfileRepository;
    }

    @Override
    public void run(String... args) {
        PortfolioProfile profile = portfolioProfileRepository.findTopByOrderByIdAsc()
                .orElseGet(PortfolioProfile::new);

        profile.setFullName("Kawithma");
        profile.setHeadline("IT Undergraduate");
        profile.setShortBio("Passionate about building clean, practical software solutions with a growing focus on full-stack development.");
        profile.setAvailabilityText("Available for Work");
        profile.setHireStatus("Available for hire");
        profile.setResumeUrl("/N.H.K.T.Ransitha.pdf");
        profile.setProfileImageUrl("/IMAGE.jpeg");
        profile.setEmail("kavithmathushal57@gmail.com");
        profile.setPhone("0724397586");
        profile.setLocation("Amalgoda, Akuressa");
        profile.setGithubUrl("https://github.com/KawithmaThushal");
        profile.setLinkedinUrl("https://www.linkedin.com/in/kawithma-thushal");
        portfolioProfileRepository.save(profile);
    }
}
