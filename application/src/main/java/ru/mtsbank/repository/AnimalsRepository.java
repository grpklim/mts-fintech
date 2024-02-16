package ru.mtsbank.repository;

import ru.mtsbank.animals.Animal;

import java.util.Set;

public interface AnimalsRepository {
    String[] findLeapYearNames();

    Animal[] findOlderAnimal(int N);

    Set<Animal> findDuplicate();

    Animal[] getAnimals();

    void printDuplicate();
}