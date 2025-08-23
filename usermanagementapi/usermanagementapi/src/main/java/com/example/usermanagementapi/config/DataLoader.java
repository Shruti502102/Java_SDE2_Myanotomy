package com.example.usermanagementapi.config;

import com.example.usermanagementapi.model.User;
import com.example.usermanagementapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner seedAdmin(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            String adminEmail = "admin@example.com";
            if (!repo.existsByEmail(adminEmail)) {
                User admin = new User(
                        "Admin",
                        adminEmail,
                        encoder.encode("admin123"), // change in prod
                        Set.of("ROLE_ADMIN")
                );
                repo.save(admin);
            }
        };
    }
}


