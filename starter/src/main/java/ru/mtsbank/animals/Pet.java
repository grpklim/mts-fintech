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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pet pet = (Pet) o;
        return breed.equals(pet.breed) && name.equals(pet.name) && character.equals(pet.character) &&
                cost.equals(pet.cost) && birthDate.equals(pet.birthDate);
    }

    @Override
    public int hashCode() {
        return breed.hashCode() + name.hashCode() + character.hashCode() + cost.hashCode() + birthDate.hashCode();
    }
}