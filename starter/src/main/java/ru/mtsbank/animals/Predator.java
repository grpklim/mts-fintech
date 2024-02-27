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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Predator predator = (Predator) o;
        return breed.equals(predator.breed) && name.equals(predator.name) && character.equals(predator.character)
                && birthDate.equals(predator.birthDate);
    }

    @Override
    public int hashCode() {
        return breed.hashCode() + name.hashCode() + character.hashCode() + birthDate.hashCode();
    }
}