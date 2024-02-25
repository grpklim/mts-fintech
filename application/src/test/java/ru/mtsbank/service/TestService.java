package ru.mtsbank.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mtsbank.animals.Animal;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestService {
    @Autowired
    private CreateAnimalServiceImpl service;

    @Test
    public void testCreate() {
        Map<String, List<Animal>> testAnimals = service.create();
        Assertions.assertTrue(testAnimals.size() > 0 && testAnimals.size() < 5);
    }
}