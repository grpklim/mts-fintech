package ru.mtsbank.animals;

import java.time.format.DateTimeFormatter;

public class Shark extends Predator {
    public Shark(String breed, String name, String character) {
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
        return "Shark: " + breed + ", " + name + ", " + character + ", " + getBirthDay().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}