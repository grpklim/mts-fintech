package ru.mtsbank.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mtsbank.animals.Animal;

import java.util.Random;

@Service
@Scope(value = "prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {
    private AnimalFactory animalFactory;

    public CreateAnimalServiceImpl(AnimalFactory factory) {
        animalFactory = factory;
    }

    public Animal create(AnimalType type) {
        return animalFactory.createAnimal(type, new Random().nextInt(10));
    }
}