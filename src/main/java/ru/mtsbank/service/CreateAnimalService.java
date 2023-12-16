package ru.mtsbank.service;

import ru.mtsbank.animals.*;

import java.math.BigDecimal;

public interface CreateAnimalService {
    default void createAnimal() {
        System.out.println("Метод createAnimal() из CreateAnimalService");
        int count = 1;
        while (count <= 10) {
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
        }
    }
}