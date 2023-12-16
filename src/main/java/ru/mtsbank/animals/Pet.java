package ru.mtsbank.animals;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Pet extends AbstractAnimal {
    public Pet(String breed, String name, String character, BigDecimal cost) {
        this.breed = breed;
        this.name = name;
        this.character = character;
        this.cost = cost.setScale(2, RoundingMode.DOWN);
    }
}