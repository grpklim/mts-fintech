/*
 * Для тестов
 *   - закомментировал проверку на равенство дней рождения в методе equals()
 *   - закомментировал добавление хэшкода birthDate к хэшкоду животного
 *   - сделал поле LocalDate birthDate у животных публичным
 *   - изменил метод findDuplicate(), чтобы он помимо вывода животных на экран еще и возвращал массив этих животных
 */

package ru.mtsbank;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mtsbank.animals.*;
import ru.mtsbank.service.SearchServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainTest {
    @Nested
    public class Test1 {
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

    @Nested
    public class Test234 {
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
}