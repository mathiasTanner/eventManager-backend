package com.mg.eventmanager;

import com.mg.eventmanager.domain.Business.EventManagerTools;
import com.mg.eventmanager.domain.repositories.EventRepository;
import com.mg.eventmanager.domain.repositories.LocationRepository;
import com.mg.eventmanager.domain.repositories.ParticipationRepository;
import com.mg.eventmanager.domain.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EventmanagerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
        return app.sources(EventmanagerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EventmanagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner managerInit(EventRepository eventRepo, ParticipationRepository partRepo, UserRepository userRepo, LocationRepository locRepo) {
        return (args) -> {
            EventManagerTools.initializeEnvironmment(eventRepo, partRepo, userRepo, locRepo);

        };
    }

}
