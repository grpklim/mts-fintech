package ru.mtsbank.service;

import ru.mtsbank.animals.Animal;

import java.time.LocalDate;
import java.util.*;

public class SearchServiceImpl implements SearchService {
    @Override
    public String[] findLeapYearNames(Animal[] animals) {
        if (animals.length == 0)
            throw new RuntimeException("Пустой массив");
        List<String> list = new ArrayList<>();
        for (Animal animal : animals)
            if (animal.getBirthDay().isLeapYear())
                list.add(animal.getName());
        return list.toArray(new String[list.size()]);
    }

    @Override
    public Animal[] findOlderAnimal(Animal[] animals, int N) {
        if (animals.length == 0)
            throw new RuntimeException("Пустой массив");
        List<Animal> list = new ArrayList<>();
        for (Animal animal : animals)
            if (LocalDate.now().getYear() - animal.getBirthDay().getYear() > N)
                list.add(animal);
        return list.toArray(new Animal[list.size()]);
    }

    @Override
    public void findDuplicate(Animal[] animals) {
        if (animals.length == 0)
            throw new RuntimeException("Пустой массив");
        int count = 0;
        System.out.println("Дубликаты:");
        Set<Animal> set = new HashSet<>();
        for (Animal animal : animals)
            if (!set.add(animal)) {
                System.out.println(animal);
                count++;
            }
        if (count == 0)
            System.out.println("Без дубликатов");
    }
}