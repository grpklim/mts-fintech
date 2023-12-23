package ru.mtsbank.animals;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Cat extends Pet {
    public Cat(String breed, String name, String character, BigDecimal cost) {
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
        return "Cat: " + breed + ", " + name + ", " + character + ", " + cost + ", "
                + getBirthDay().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}