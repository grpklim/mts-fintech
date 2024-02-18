package ru.mtsbank.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mtsbank.service.AnimalFactory;

@Configuration
@EnableConfigurationProperties(StarterProperties.class)
public class StarterConfiguration {
    @Bean
    public AnimalFactory animalFactory(StarterProperties properties) {
        return new AnimalFactory(properties);
    }
}