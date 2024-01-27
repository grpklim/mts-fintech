package ru.mtsbank.animals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mtsbank.service.SearchServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SecondTest {
    private static SearchServiceImpl ssi;
    private static Cat cat;
    private static Dog dog;
    private static Shark shark;
    private static Wolf wolf;
    private static Animal[] animals;

    @BeforeAll
    public static void beforeAll() {
        ssi = new SearchServiceImpl();
        cat = new Cat("Порода", "Кошка", "Характер", new BigDecimal("0"));
        dog = new Dog("Порода", "Собака", "Характер", new BigDecimal("0"));
        shark = new Shark("Порода", "Акула", "Характер");
        wolf = new Wolf("Порода", "Волк", "Характер");
        cat.birthDate = LocalDate.now();
        dog.birthDate = LocalDate.parse("2022-01-01");
        shark.birthDate = LocalDate.parse("2016-01-01");
        wolf.birthDate = LocalDate.parse("2009-01-01");
        animals = new Animal[]{cat, dog, shark, wolf};
    }

    @DisplayName("тестируем метод findLeapYearNames()")
    @Test
    public void findLeapYearNamesTest() {
        Assertions.assertArrayEquals(ssi.findLeapYearNames(animals), new String[]{"Кошка", "Акула"});
    }

    @ParameterizedTest(name = "тест со значением N = {arguments}")
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("тестируем метод findOlderAnimal()")
    public void findOlderAnimalTest(int N) {
        switch (N) {
            case 1 -> Assertions.assertArrayEquals(ssi.findOlderAnimal(animals, N), new Animal[]{dog, shark, wolf});
            case 5 -> Assertions.assertArrayEquals(ssi.findOlderAnimal(animals, N), new Animal[]{shark, wolf});
            case 10 -> Assertions.assertArrayEquals(ssi.findOlderAnimal(animals, N), new Animal[]{wolf});
        }
    }

    @DisplayName("тестируем метод findDuplicate() без дубликатов")
    @Test
    public void findDuplicateTest1() {
        Assertions.assertArrayEquals(ssi.findDuplicate(animals), new Animal[]{});
    }

    @DisplayName("тестируем метод findDuplicate() с дубликатами")
    @Test
    public void findDuplicateTest2() {
        Animal[] animalsDup = {cat, dog, new Cat("Порода", "Кошка", "Характер", new BigDecimal("0"))};
        Assertions.assertArrayEquals(ssi.findDuplicate(animalsDup), new Animal[]{cat});
    }
}