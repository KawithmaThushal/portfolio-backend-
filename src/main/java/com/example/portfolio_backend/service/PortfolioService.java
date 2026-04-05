package com.example.portfolio_backend.service;

import com.example.portfolio_backend.dto.ContactDetailDto;
import com.example.portfolio_backend.dto.ContactRequest;
import com.example.portfolio_backend.dto.ContactResponse;
import com.example.portfolio_backend.dto.ContactSectionDto;
import com.example.portfolio_backend.dto.ExperienceItemDto;
import com.example.portfolio_backend.dto.FooterHighlightDto;
import com.example.portfolio_backend.dto.HeroSectionDto;
import com.example.portfolio_backend.dto.NavItemDto;
import com.example.portfolio_backend.dto.PortfolioProjectDto;
import com.example.portfolio_backend.dto.PortfolioResponse;
import com.example.portfolio_backend.dto.SkillGroupDto;
import com.example.portfolio_backend.dto.SocialLinkDto;
import com.example.portfolio_backend.dto.StatItemDto;
import com.example.portfolio_backend.entity.ContactMessage;
import com.example.portfolio_backend.entity.PortfolioProfile;
import com.example.portfolio_backend.repository.ContactMessageRepository;
import com.example.portfolio_backend.repository.PortfolioProfileRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    private final PortfolioProfileRepository portfolioProfileRepository;
    private final ContactMessageRepository contactMessageRepository;

    public PortfolioService(
            PortfolioProfileRepository portfolioProfileRepository,
            ContactMessageRepository contactMessageRepository
    ) {
        this.portfolioProfileRepository = portfolioProfileRepository;
        this.contactMessageRepository = contactMessageRepository;
    }

    public PortfolioResponse getPortfolio() {
        PortfolioProfile profile = portfolioProfileRepository.findTopByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("Portfolio profile data not found"));

        return new PortfolioResponse(
                profile.getFullName(),
                List.of(
                        new NavItemDto("Home", "#home"),
                        new NavItemDto("Skills", "#skills"),
                        new NavItemDto("Experience", "#experience"),
                        new NavItemDto("Projects", "#projects"),
                        new NavItemDto("Contact", "#contact")
                ),
                new HeroSectionDto(
                        profile.getAvailabilityText(),
                        "Hello, I'm " + profile.getFullName(),
                        profile.getHeadline(),
                        profile.getShortBio(),
                        profile.getResumeUrl(),
                        profile.getProfileImageUrl(),
                        profile.getFullName(),
                        profile.getHireStatus()
                ),
                List.of(
                        new SocialLinkDto("GitHub", profile.getGithubUrl(), "github"),
                        new SocialLinkDto("LinkedIn", profile.getLinkedinUrl(), "linkedin"),
                        new SocialLinkDto("Email", "mailto:" + profile.getEmail(), "mail")
                ),
                List.of(
                        new StatItemDto("6+", "Projects"),
                        new StatItemDto("1", "Internship"),
                        new StatItemDto("1", "Publication")
                ),
                List.of(
                        new SkillGroupDto("Programming Languages", "code", List.of("Java", "JavaScript", "PHP", "Python", "C", "C#")),
                        new SkillGroupDto("Frontend & UI", "globe", List.of("HTML", "CSS", "Tailwind CSS", "React", "ASP.NET")),
                        new SkillGroupDto("Backend & Frameworks", "server", List.of("Spring Boot", "RESTful APIs", "MVC Architecture", "JavaFX")),
                        new SkillGroupDto("Databases", "terminal", List.of("MySQL", "PostgreSQL", "MongoDB", "Hibernate", "SQL")),
                        new SkillGroupDto("Full Stack Stack", "code", List.of("MERN", "Spring Boot", "JavaScript", "MySQL")),
                        new SkillGroupDto("Soft Skills", "terminal", List.of("Teamwork", "Adaptability", "Problem Solving", "Leadership"))
                ),
                List.of(
                        new ExperienceItemDto(
                                "Intern Software Developer",
                                "Nekfa Australia (PVT) Limited",
                                "30 January 2023 - 30 March 2023",
                                "Negombo Municipal Council",
                                "Contributed to the development of solutions for the procurement service in the Negombo Municipal Council environment, working on practical business needs and collaborative delivery.",
                                List.of("Java", "Software Development", "Problem Solving", "Team Collaboration")
                        )
                ),
                List.of(
                        new PortfolioProjectDto(
                                "Point-of-Sale System (POS)",
                                "A full-stack retail POS system built for billing, inventory, suppliers, loyalty handling, returns, reporting, and secure role-based operations.",
                                "/projects/pos-dashboard.png",
                                null,
                                "https://github.com/KawithmaThushal/POS-System-Frontend.git",
                                "https://github.com/KawithmaThushal/POS-system-Backend.git",
                                List.of("React", "TypeScript", "Tailwind CSS", "Spring Boot", "Spring Security", "PostgreSQL")
                        ),
                        new PortfolioProjectDto(
                                "Letter Management System",
                                "A secure full-stack letter management system developed for the Southern Province Department of Ayurveda to register letters, track progress, manage actions, and generate operational reports.",
                                "https://images.unsplash.com/photo-1455390582262-044cdead277a?auto=format&fit=crop&w=1200&q=80",
                                null,
                                null,
                                null,
                                List.of("React", "TypeScript", "Tailwind CSS", "Spring Boot", "Spring Security", "PostgreSQL")
                        ),
                        new PortfolioProjectDto(
                                "SparkGo",
                                "A travel planning platform focused on Sri Lankan destinations, EV charging support, trip planning, and curated travel guidance through a modern full-stack web experience.",
                                "https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1200&q=80",
                                null,
                                "https://github.com/KawithmaThushal/SparkGo-Frontend.git",
                                "https://github.com/KawithmaThushal/Sparkgo-Backend.git",
                                List.of("React", "TypeScript", "Tailwind CSS", "Spring Boot", "MySQL", "REST API")
                        ),
                        new PortfolioProjectDto(
                                "Library Management System",
                                "A Java desktop library system built to manage members, book registration, issuing, returns, and report generation through a layered application structure.",
                                "https://images.unsplash.com/photo-1521587760476-6c12a4b040da?auto=format&fit=crop&w=1200&q=80",
                                null,
                                "https://github.com/KawithmaThushal/Library-Management-System-.git",
                                null,
                                List.of("Java", "JavaFX", "FXML", "PostgreSQL", "Layered Architecture")
                        ),
                        new PortfolioProjectDto(
                                "PharmaB Research Project",
                                "A final-year research project focused on counterfeit drug detection and medicine traceability using blockchain, QR verification, secure storage, and AI-assisted analysis.",
                                "https://images.unsplash.com/photo-1587854692152-cbe660dbde88?auto=format&fit=crop&w=1200&q=80",
                                null,
                                null,
                                null,
                                List.of("React", "TypeScript", "Tailwind CSS", "Blockchain", "AI/ML", "Clerk")
                        ),
                        new PortfolioProjectDto(
                                "BeanStack Coffee Shop Web",
                                "A web application for a coffee shop featuring customer registration, login, and a branded browsing experience built with ASP.NET Web Forms.",
                                "https://images.unsplash.com/photo-1509042239860-f550ce710b93?auto=format&fit=crop&w=1200&q=80",
                                null,
                                "https://github.com/KawithmaThushal/BeanStack-Coffee-Shop-Web.git",
                                null,
                                List.of("ASP.NET", "C#", "Web Forms", "Bootstrap", "JavaScript")
                        )
                ),
                new ContactSectionDto(
                        List.of(
                                new ContactDetailDto("mail", "Email", profile.getEmail()),
                                new ContactDetailDto("phone", "Phone", profile.getPhone()),
                                new ContactDetailDto("location", "Location", profile.getLocation())
                        ),
                        List.of(
                                new FooterHighlightDto(
                                        "Degree",
                                        "BHSc (Hons) in Health Information and Communication Technology",
                                        "Gampaha Wickramarachchi University of Indigenous Medicine"
                                ),
                                new FooterHighlightDto(
                                        "Diploma",
                                        "Comprehensive Master Java Developer (CMJD)",
                                        "Institute of Software Engineering (IJSE)"
                                )
                        ),
                        profile.getFullName()
                )
        );
    }

    public ContactResponse saveContactMessage(ContactRequest request) {
        ContactMessage contactMessage = new ContactMessage();
        contactMessage.setName(request.name());
        contactMessage.setEmail(request.email());
        contactMessage.setSubject(request.subject());
        contactMessage.setMessage(request.message());
        contactMessageRepository.save(contactMessage);

        return new ContactResponse("success", "Message received successfully.");
    }
}
