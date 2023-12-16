package ru.mtsbank.animals;

import java.math.BigDecimal;

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
}