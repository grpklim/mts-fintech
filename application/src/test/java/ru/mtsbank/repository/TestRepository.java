package ru.mtsbank.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.mtsbank.animals.*;
import ru.mtsbank.exception.CustomExecutionException;
import ru.mtsbank.exception.CustomIllegalArgumentException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

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
    private static List<Animal> list;

    @BeforeAll
    public static void beforeAll() {
        cat = new Cat("Порода", "Кошка", "Характер", new BigDecimal("0"));
        dog = new Dog("Порода", "Собака", "Характер", new BigDecimal("1"));
        shark = new Shark("Порода", "Акула", "Характер");
        wolf = new Wolf("Порода", "Волк", "Характер");
        cat.setBirthDate(LocalDate.now());
        dog.setBirthDate(LocalDate.parse("2017-01-01"));
        shark.setBirthDate(LocalDate.parse("2016-01-01"));
        wolf.setBirthDate(LocalDate.parse("2009-01-01"));
        list = List.of(cat, dog, shark, wolf);
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
        Assertions.assertEquals(map, ari.findLeapYearNames());
    }

    @DisplayName("тестируем метод findOlderAnimal()")
    @Test
    public void findOlderAnimalTest() {
        Map<Animal, Integer> map = new HashMap<>();
        map.put(shark, 8);
        map.put(wolf, 15);
        Assertions.assertEquals(map, ari.findOlderAnimal(7));
    }

    @DisplayName("тестируем метод findOlderAnimal() c исключением")
    @Test
    public void exceptionTest1() {
        Assertions.assertThrows(CustomIllegalArgumentException.class, () -> ari.findOlderAnimal(-1));
    }

    @DisplayName("тестируем метод findDuplicate()")
    @Test
    public void findDuplicateTest() {
        Assertions.assertEquals(new HashMap<>(), ari.findDuplicate());
    }

    @DisplayName("тестируем метод findAverageAge()")
    @Test
    public void findAverageAgeTest() {
        Assertions.assertEquals(7.5, ari.findAverageAge(list));
    }

    @DisplayName("тестируем метод findOldAndExpensive()")
    @Test
    public void findOldAndExpensiveTest() {
        Assertions.assertEquals(List.of(dog), ari.findOldAndExpensive(list));
    }

    @DisplayName("тестируем метод findMinConstAnimals()")
    @Test
    public void findMinConstAnimalsTest() throws CustomExecutionException {
        Assertions.assertEquals(List.of("Собака", "Кошка"), ari.findMinConstAnimals(list));
    }

    @DisplayName("тестируем метод findMinConstAnimals() c исключением")
    @Test
    public void exceptionTest2() {
        Assertions.assertThrows(CustomExecutionException.class, () -> ari.findMinConstAnimals(new ArrayList<>()));
    }
}