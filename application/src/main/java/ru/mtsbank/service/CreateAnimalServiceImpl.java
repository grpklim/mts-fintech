package ru.mtsbank.service;

import org.springframework.stereotype.Service;
import ru.mtsbank.animals.Animal;

import java.util.*;

@Service
public class CreateAnimalServiceImpl implements CreateAnimalService {
    private AnimalFactory animalFactory;

    public CreateAnimalServiceImpl(AnimalFactory factory) {
        animalFactory = factory;
    }

    public Map<String, List<Animal>> create() {
        Map<String, List<Animal>> animals = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            AnimalType type = getType();
            if (!animals.containsKey(type.toString()))
                animals.put(type.toString(), new ArrayList<>());
            animals.get(type.toString()).add(animalFactory.createAnimal(type, new Random().nextInt(10)));
        }
        return animals;
    }

    private AnimalType getType() {
        AnimalType type = null;
        switch (new Random().nextInt(4)) {
            case 0 -> type = AnimalType.CAT;
            case 1 -> type = AnimalType.DOG;
            case 2 -> type = AnimalType.SHARK;
            case 3 -> type = AnimalType.WOLF;
        }
        return type;
    }
}