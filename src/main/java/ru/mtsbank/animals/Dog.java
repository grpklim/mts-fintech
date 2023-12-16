package ru.mtsbank.animals;

import java.math.BigDecimal;

public class Dog extends Pet {
    public Dog(String breed, String name, String character, BigDecimal cost) {
        super(breed, name, character, cost);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Dog: breed = " + breed + ", name = " + name + ", character = " + character + ", cost = " + cost;
    }
}