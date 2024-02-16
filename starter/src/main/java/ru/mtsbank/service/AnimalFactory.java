package ru.mtsbank.service;

import org.springframework.stereotype.Component;
import ru.mtsbank.animals.*;

import java.math.BigDecimal;

@Component
public class AnimalFactory {
    public Animal createAnimal(AnimalType type, String name, int index) {
        switch (type) {
            case CAT:
                return new Cat("Порода " + index, name, "Характер " + index,
                        new BigDecimal(String.valueOf(index * 5433.232443)));
            case DOG:
                return new Dog("Порода " + index, name, "Характер " + index,
                        new BigDecimal(String.valueOf(index * 123.3321)));
            case WOLF:
                return new Wolf("Порода " + index, name, "Характер " + index);
            case SHARK:
                return new Shark("Порода " + index, name, "Характер " + index);
        }
        return null;
    }
}