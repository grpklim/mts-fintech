package ru.mtsbank.service;

import org.springframework.stereotype.Component;
import ru.mtsbank.animals.*;
import ru.mtsbank.config.StarterProperties;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class AnimalFactory {
    private StarterProperties starterProperties;

    public AnimalFactory(StarterProperties properties) {
        starterProperties = properties;
    }

    public Animal createAnimal(AnimalType type, int index) {
        String[] names;
        switch (type) {
            case CAT -> {
                names = starterProperties.getCatNames();
                return new Cat("Порода " + index, names[new Random().nextInt(names.length)], "Характер " + index,
                        new BigDecimal(String.valueOf(index * 5433.232443)));
            }
            case DOG -> {
                names = starterProperties.getDogNames();
                return new Dog("Порода " + index, names[new Random().nextInt(names.length)], "Характер " + index,
                        new BigDecimal(String.valueOf(index * 123.3321)));
            }
            case WOLF -> {
                names = starterProperties.getWolfNames();
                return new Wolf("Порода " + index, names[new Random().nextInt(names.length)], "Характер " + index);
            }
            case SHARK -> {
                names = starterProperties.getSharkNames();
                return new Shark("Порода " + index, names[new Random().nextInt(names.length)], "Характер " + index);
            }
        }
        return null;
    }
}