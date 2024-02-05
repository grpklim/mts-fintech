package ru.mtsbank.service;

import org.springframework.stereotype.Repository;
import ru.mtsbank.animals.Animal;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {
    private Animal[] animals;

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    @PostConstruct
    public void init() {
        animals = new Animal[10];
    }

    @Override
    public String[] findLeapYearNames() {
        if (animals.length == 0)
            throw new RuntimeException("Пустой массив");
        List<String> list = new ArrayList<>();
        for (Animal animal : animals)
            if (animal.getBirthDay().isLeapYear())
                list.add(animal.getName());
        return list.toArray(new String[list.size()]);
    }

    @Override
    public Animal[] findOlderAnimal(int N) {
        if (animals.length == 0)
            throw new RuntimeException("Пустой массив");
        List<Animal> list = new ArrayList<>();
        for (Animal animal : animals)
            if (LocalDate.now().getYear() - animal.getBirthDay().getYear() > N)
                list.add(animal);
        return list.toArray(new Animal[list.size()]);
    }

    @Override
    public Set<Animal> findDuplicate() {
        if (animals.length == 0)
            throw new RuntimeException("Пустой массив");
        int count = 0;
        System.out.println("Дубликаты:");
        Set<Animal> set = new HashSet<>();
        Set<Animal> result = new HashSet<>();
        for (Animal animal : animals)
            if (!set.add(animal)) {
                System.out.println(animal);
                result.add(animal);
                count++;
            }
        if (count == 0)
            System.out.println("Без дубликатов");
        return result;
    }
}