package ru.mtsbank.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mtsbank.service.AnimalFactory;
import ru.mtsbank.service.CreateAnimalServiceImpl;

@Configuration
@EnableConfigurationProperties(StarterProperties.class)
public class StarterConfiguration {
    @Bean
    @Scope(value = "prototype")
    public CreateAnimalServiceImpl serviceConfig(StarterProperties properties, AnimalFactory factory) {
        return new CreateAnimalServiceImpl(properties, factory);
    }
}