package ru.mtsbank.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.animals.Cat;
import ru.mtsbank.config.StarterProperties;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestService {
    @MockBean
    private AnimalFactory factory;

    @MockBean
    private StarterProperties properties;

    @Autowired
    private CreateAnimalServiceImpl service;

    @Test
    public void testCreate() {
        Cat cat = new Cat("Порода", "catName1", "Характер", new BigDecimal("0.0"));
        when(factory.createAnimal(eq(AnimalType.CAT), anyInt())).thenReturn(cat);
        when(properties.getCatNames()).thenReturn(new String[]{"catName1"});
        Animal testCat = service.create(AnimalType.CAT);
        Assertions.assertEquals(cat, testCat);
    }
}