package ru.mtsbank.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.mtsbank.animals.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, List<Animal>> animals = new HashMap<>();
        animals.put("CAT", new ArrayList<>(List.of(cat)));
        animals.put("DOG", new ArrayList<>(List.of(dog)));
        animals.put("SHARK", new ArrayList<>(List.of(shark)));
        animals.put("WOLF", new ArrayList<>(List.of(wolf)));
        ari.setAnimals(animals);
    }

    @DisplayName("тестируем метод findLeapYearNames()")
    @Test
    public void findLeapYearNamesTest() {
        Map<String, LocalDate> map = new HashMap<>();
        map.put("CAT Кошка", cat.getBirthDay());
        map.put("SHARK Акула", shark.getBirthDay());
        Assertions.assertEquals(ari.findLeapYearNames(), map);
    }

    @DisplayName("тестируем метод findOlderAnimal()")
    @Test
    public void findOlderAnimalTest() {
        Map<Animal, Integer> map = new HashMap<>();
        map.put(shark, 8);
        map.put(wolf, 15);
        Assertions.assertEquals(ari.findOlderAnimal(5), map);
    }

    @DisplayName("тестируем метод findDuplicate()")
    @Test
    public void findDuplicateTest1() {
        Assertions.assertEquals(ari.findDuplicate(), new HashMap<>());
    }
}