package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;

import java.util.Set;

public interface AnimalsRepository {
    String[] findLeapYearNames();

    Animal[] findOlderAnimal(int N);

    Set<Animal> findDuplicate();

    Animal[] getAnimals();
}