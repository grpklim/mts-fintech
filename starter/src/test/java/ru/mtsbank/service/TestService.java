package ru.mtsbank.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.animals.Cat;
import ru.mtsbank.config.StarterProperties;
import ru.mtsbank.service.AnimalFactory;
import ru.mtsbank.service.AnimalType;
import ru.mtsbank.service.CreateAnimalServiceImpl;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestService {
    @Mock
    private AnimalFactory factory;

    @Mock
    private StarterProperties properties;

    @InjectMocks
    private CreateAnimalServiceImpl service;

    @Test
    public void testCreate() {
        Cat cat = new Cat("Порода", "catName1", "Характер", new BigDecimal("0.0"));
        when(factory.createAnimal(eq(AnimalType.CAT), anyString(), anyInt())).thenReturn(cat);
        when(properties.getCatNames()).thenReturn(new String[]{"catName1"});
        service.type = AnimalType.CAT;
        Animal testCat = service.create();
        Assertions.assertEquals(cat, testCat);
    }
}