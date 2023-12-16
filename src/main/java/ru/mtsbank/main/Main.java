package ru.mtsbank.main;

import ru.mtsbank.service.CreateAnimalServiceImpl;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl casi = new CreateAnimalServiceImpl();
        casi.createAnimal();
        System.out.println();
        casi.createAnimal(10);
        System.out.println();
        casi.invokeCreateAnimalFromInterface();
    }
}