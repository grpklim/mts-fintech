package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;

import java.util.List;
import java.util.Map;

public interface CreateAnimalService {
    Map<String, List<Animal>> create();
}