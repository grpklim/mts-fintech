package ru.mtsbank.service;

import ru.mtsbank.animals.*;

import java.math.BigDecimal;

public class AnimalFactory {
    public Animal createAnimal(AnimalType type, int index) {
        switch (type) {
            case CAT:
                return new Cat("Порода " + index, "Имя " + index, "Характер " + index,
                        new BigDecimal(String.valueOf(index * 5433.232443)));
            case DOG:
                return new Dog("Порода " + index, "Имя " + index, "Характер " + index,
                        new BigDecimal(String.valueOf(index * 123.3321)));
            case WOLF:
                return new Wolf("Порода " + index, "Имя " + index, "Характер " + index);
            case SHARK:
                return new Shark("Порода " + index, "Имя " + index, "Характер " + index);
        }
        return null;
    }
}