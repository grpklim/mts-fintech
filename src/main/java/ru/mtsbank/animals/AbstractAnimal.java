package ru.mtsbank.animals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;
    protected LocalDate birthDate;

    public AbstractAnimal() {
        birthDate = LocalDate.ofEpochDay(new Random().nextInt(19715));
    }

    @Override
    public LocalDate getBirthDay() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}