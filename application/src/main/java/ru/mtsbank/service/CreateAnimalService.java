package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;

import java.util.*;

public interface CreateAnimalService {
    Map<String, List<Animal>> create();
}