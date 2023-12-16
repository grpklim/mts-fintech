package ru.mtsbank.service;

import ru.mtsbank.animals.*;

import java.math.BigDecimal;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public void createAnimal() {
        System.out.println("Метод createAnimal() из CreateAnimalServiceImpl");
        int count = 1;
        do {
            System.out.print(count + ") ");
            if (count < 2)
                System.out.println(new Wolf("Порода " + count, "Имя " + count, "Характер " + count));
            else if (count < 4)
                System.out.println(new Shark("Порода " + count, "Имя " + count, "Характер " + count));
            else if (count < 7) {
                String cost = String.valueOf(count * 1324.443325564);
                System.out.println(new Dog("Порода " + count, "Имя " + count, "Характер " + count,
                        new BigDecimal(cost)));
            } else {
                String cost = String.valueOf(count * 332.28899903);
                System.out.println(new Cat("Порода " + count, "Имя " + count, "Характер " + count,
                        new BigDecimal(cost)));
            }
            count++;
        } while (count <= 10);
    }

    public void createAnimal(int N) {
        System.out.println("Метод createAnimal(int N) из CreateAnimalServiceImpl");
        for (int i = 1; i <= N; i++) {
            System.out.print(i + ") ");
            if (i < N / 4)
                System.out.println(new Wolf("Порода " + i, "Имя " + i, "Характер " + i));
            else if (i < N / 2)
                System.out.println(new Shark("Порода " + i, "Имя " + i, "Характер " + i));
            else if (i < 3 * N / 4) {
                String cost = String.valueOf(i * 1324.443325564);
                System.out.println(new Dog("Порода " + i, "Имя " + i, "Характер " + i,
                        new BigDecimal(cost)));
            } else {
                String cost = String.valueOf(i * 332.28899903);
                System.out.println(new Cat("Порода " + i, "Имя " + i, "Характер " + i,
                        new BigDecimal(cost)));
            }
        }
    }

    public void invokeCreateAnimalFromInterface() {
        CreateAnimalService.super.createAnimal();
    }
}