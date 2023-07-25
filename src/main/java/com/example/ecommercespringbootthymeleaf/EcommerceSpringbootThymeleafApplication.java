package com.example.ecommercespringbootthymeleaf;

import com.example.ecommercespringbootthymeleaf.common.auditor.SecurityAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class EcommerceSpringbootThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceSpringbootThymeleafApplication.class, args);
    }
    @Bean
    public AuditorAware<Long> auditorAware() {
        return new SecurityAuditorAware();
    }
}
