package ru.mtsbank.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mtsbank.animals.Animal;

import java.util.Random;

@Service
@Scope(value = "prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {
    @TempAnnoAnimalType
    protected AnimalType type;

    public Animal create() {
        return animalFactory.createAnimal(type, new Random().nextInt(10));
    }
}