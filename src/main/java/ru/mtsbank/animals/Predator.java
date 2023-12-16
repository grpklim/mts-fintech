package ru.mtsbank.animals;

import java.math.BigDecimal;

public abstract class Predator extends AbstractAnimal {
    public Predator(String breed, String name, String character) {
        this.breed = breed;
        this.name = name;
        this.character = character;
        cost = null;
    }

    @Override
    public BigDecimal getCost() {
        System.out.println("Не продается в магазине");
        return null;
    }
}