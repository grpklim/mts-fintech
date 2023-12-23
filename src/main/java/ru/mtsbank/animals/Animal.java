package ru.mtsbank.animals;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {
    /**
     * Возвращает породу животного
     */
    String getBreed();

    /**
     * Возвращает имя животного
     */
    String getName();

    /**
     * Возвращает цену животного
     */
    BigDecimal getCost();

    /**
     * Возвращает характер животного
     */
    String getCharacter();

    /**
     * Возвращает день рождения животного
     */
    LocalDate getBirthDay();
}