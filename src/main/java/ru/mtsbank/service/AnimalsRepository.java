package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;

public interface AnimalsRepository {
    String[] findLeapYearNames();

    Animal[] findOlderAnimal(int N);

    void findDuplicate();

    Animal[] getAnimals();
}