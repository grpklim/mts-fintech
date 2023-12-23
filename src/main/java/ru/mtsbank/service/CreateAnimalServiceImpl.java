package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;

import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public Animal[] createAnimal() {
        Animal[] animals = new Animal[10];
        Random random = new Random();
        System.out.println("Метод createAnimal() из CreateAnimalServiceImpl");
        int count = 0;
        do {
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
        } while (count < 10);
        return animals;
    }

    public Animal[] createAnimal(int N) {
        Animal[] animals = new Animal[N];
        Random random = new Random();
        System.out.println("Метод createAnimal(int N) из CreateAnimalServiceImpl");
        for (int i = 0; i < N; i++) {
            int index = random.nextInt(4);
            switch (index) {
                case 0:
                    animals[i] = animalFactory.createAnimal(AnimalType.CAT, random.nextInt(N));
                    break;
                case 1:
                    animals[i] = animalFactory.createAnimal(AnimalType.DOG, random.nextInt(N));
                    break;
                case 2:
                    animals[i] = animalFactory.createAnimal(AnimalType.SHARK, random.nextInt(N));
                    break;
                case 3:
                    animals[i] = animalFactory.createAnimal(AnimalType.WOLF, random.nextInt(N));
                    break;
            }
        }
        return animals;
    }

    public void invokeCreateAnimalFromInterface() {
        CreateAnimalService.super.createAnimal();
    }
}