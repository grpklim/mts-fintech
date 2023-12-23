package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;

import java.util.Random;

public interface CreateAnimalService {
    AnimalFactory animalFactory = new AnimalFactory();

    default Animal[] createAnimal() {
        Animal[] animals = new Animal[10];
        Random random = new Random();
        System.out.println("Метод createAnimal() из CreateAnimalService");
        int count = 0;
        while (count < 10) {
            int index = random.nextInt(4);
            switch (index) {
                case 0:
                    animals[count] = animalFactory.createAnimal(AnimalType.CAT, random.nextInt(10));
                    break;
                case 1:
                    animals[count] = animalFactory.createAnimal(AnimalType.DOG, random.nextInt(10));
                    break;
                case 2:
                    animals[count] = animalFactory.createAnimal(AnimalType.SHARK, random.nextInt(10));
                    break;
                case 3:
                    animals[count] = animalFactory.createAnimal(AnimalType.WOLF, random.nextInt(10));
                    break;
            }
            count++;
        }
        return animals;
    }
}