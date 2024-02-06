package ru.mtsbank.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

public class TestService {
    private CreateAnimalServiceImpl casi = new CreateAnimalServiceImpl();

    @RepeatedTest(10)
    public void test() {
        int i = new Random().nextInt(4);
        switch (i) {
            case 0 -> casi.type = AnimalType.CAT;
            case 1 -> casi.type = AnimalType.DOG;
            case 2 -> casi.type = AnimalType.SHARK;
            case 3 -> casi.type = AnimalType.WOLF;
        }
        Assertions.assertNotNull(casi.create());
    }
}