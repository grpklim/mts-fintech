package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;
import ru.mtsbank.config.StarterProperties;

import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    private StarterProperties starterProperties;
    private AnimalFactory animalFactory;

    public CreateAnimalServiceImpl(StarterProperties properties, AnimalFactory factory) {
        starterProperties = properties;
        animalFactory = factory;
    }

    public Animal create(AnimalType type) {
        String[] names = null;
        switch (type) {
            case CAT -> names = starterProperties.getCatNames();
            case DOG -> names = starterProperties.getDogNames();
            case SHARK -> names = starterProperties.getSharkNames();
            case WOLF -> names = starterProperties.getWolfNames();
        }
        return animalFactory.createAnimal(type, names[new Random().nextInt(names.length)], new Random().nextInt(10));
    }
}