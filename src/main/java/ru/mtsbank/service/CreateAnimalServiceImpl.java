package ru.mtsbank.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mtsbank.animals.Animal;

import java.util.Random;

@Service
@Scope(value = "prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {
    protected AnimalType type;

    AnimalFactory animalFactory = new AnimalFactory();

    public Animal create() {
        return animalFactory.createAnimal(type, new Random().nextInt(10));
    }
}