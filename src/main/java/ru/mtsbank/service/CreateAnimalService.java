package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;

public interface CreateAnimalService {
    AnimalFactory animalFactory = new AnimalFactory();

    Animal create();
}