package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;

public interface SearchService {
    /**
     * Возвращает массив имен животных, которые родились в високосный год
     *
     * @param animals - заданный массив животных
     */
    String[] findLeapYearNames(Animal[] animals);

    /**
     * Возвращает массив животных, возраст которых старше N лет
     *
     * @param animals - заданный массив животных
     * @param N       - заданное число лет
     */
    Animal[] findOlderAnimal(Animal[] animals, int N);

    /**
     * Выводит дупликаты животных
     *
     * @param animals - массив животных, в котором ищутся дупликаты
     */
    Animal[] findDuplicate(Animal[] animals);
}