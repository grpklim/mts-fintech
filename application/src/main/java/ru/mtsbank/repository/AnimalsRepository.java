package ru.mtsbank.repository;

import ru.mtsbank.animals.Animal;

import java.time.LocalDate;
import java.util.Map;

public interface AnimalsRepository {
    Map<String, LocalDate> findLeapYearNames();

    Map<Animal, Integer> findOlderAnimal(int n);

    Map<String, Integer> findDuplicate();

    void printDuplicate();
}