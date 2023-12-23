package ru.mtsbank.animals;

import java.time.format.DateTimeFormatter;

public class Wolf extends Predator {
    public Wolf(String breed, String name, String character) {
        super(breed, name, character);
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
    public String toString() {
        return "Wolf: " + breed + ", " + name + ", " + character + ", " + getBirthDay().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}