package ru.mtsbank.animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class FirstTest {
    private static Cat cat;

    @BeforeAll
    public static void beforeAll() {
        cat = new Cat("Порода 1", "Имя 1", "Характер 1", new BigDecimal("0"));
    }

    @DisplayName("сравниваем две одинаковых кошки")
    @Test
    public void test1() {
        Assertions.assertTrue(cat.equals(new Cat("Порода 1", "Имя 1", "Характер 1", new BigDecimal("0"))));
    }

    @DisplayName("сравниваем две разные кошки")
    @Test
    public void test2() {
        Assertions.assertFalse(cat.equals(new Cat("Порода 2", "Имя 2", "Характер 2", new BigDecimal("0"))));
    }

    @DisplayName("сравниваем кошку с собакой")
    @Test
    public void test3() {
        Assertions.assertFalse(cat.equals(new Dog("Порода 1", "Имя 1", "Характер 1", new BigDecimal("0"))));
    }

    @DisplayName("сравниваем кошку с акулой")
    @Test
    public void test4() {
        Assertions.assertFalse(cat.equals(new Shark("Порода 1", "Имя 1", "Характер 1")));
    }
}