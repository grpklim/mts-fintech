package ru.mtsbank.repository;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.mtsbank.animals.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;

@SpringBootTest
public class TestRepository {
    @TestConfiguration
    private static class TestRepositoryConfig {
        @Bean
        public AnimalsRepositoryImpl animalsRepository() {
            return new AnimalsRepositoryImpl();
        }
    }

    @Autowired
    private AnimalsRepositoryImpl ari;
    private static Cat cat;
    private static Dog dog;
    private static Shark shark;
    private static Wolf wolf;

    @BeforeAll
    public static void beforeAll() {
        cat = new Cat("Порода", "Кошка", "Характер", new BigDecimal("0"));
        dog = new Dog("Порода", "Собака", "Характер", new BigDecimal("0"));
        shark = new Shark("Порода", "Акула", "Характер");
        wolf = new Wolf("Порода", "Волк", "Характер");
        cat.setBirthDate(LocalDate.now());
        dog.setBirthDate(LocalDate.parse("2022-01-01"));
        shark.setBirthDate(LocalDate.parse("2016-01-01"));
        wolf.setBirthDate(LocalDate.parse("2009-01-01"));
    }

    @BeforeEach
    public void beforeEach() {
        ari.setAnimals(new Animal[]{cat, dog, shark, wolf});
    }

    @DisplayName("тестируем метод findLeapYearNames()")
    @Test
    public void findLeapYearNamesTest() {
        Assertions.assertArrayEquals(ari.findLeapYearNames(), new String[]{"Кошка", "Акула"});
    }

    @ParameterizedTest(name = "тест со значением N = {arguments}")
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("тестируем метод findOlderAnimal()")
    public void findOlderAnimalTest(int N) {
        switch (N) {
            case 1 -> Assertions.assertArrayEquals(ari.findOlderAnimal(N), new Animal[]{dog, shark, wolf});
            case 5 -> Assertions.assertArrayEquals(ari.findOlderAnimal(N), new Animal[]{shark, wolf});
            case 10 -> Assertions.assertArrayEquals(ari.findOlderAnimal(N), new Animal[]{wolf});
        }
    }

    @DisplayName("тестируем метод findDuplicate()")
    @Test
    public void findDuplicateTest1() {
        Assertions.assertEquals(ari.findDuplicate(), new HashSet<>());
    }
}