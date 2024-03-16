package ru.mtsbank.repository;

import ru.mtsbank.animals.Animal;
import ru.mtsbank.exception.CustomException;

import java.time.LocalDate;
import java.util.*;

public interface AnimalsRepository {
    Map<String, LocalDate> findLeapYearNames();

    Map<Animal, Integer> findOlderAnimal(int n);

    Map<String, List<Animal>> findDuplicate();

    void printDuplicate();

    double findAverageAge(List<Animal> list);

    List<Animal> findOldAndExpensive(List<Animal> list);

    List<String> findMinConstAnimals(List<Animal> list) throws CustomException;
}