package ru.mtsbank.animals;

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
        return "Shark: breed = " + breed + ", name = " + name + ", character = " + character + ", cost = " + cost;
    }
}