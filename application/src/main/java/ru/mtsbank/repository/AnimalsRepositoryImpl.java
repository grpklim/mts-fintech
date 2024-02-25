package ru.mtsbank.repository;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.service.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {
    private Map<String, List<Animal>> animals;

    public Map<String, List<Animal>> getAnimals() {
        return animals;
    }

    public void setAnimals(Map<String, List<Animal>> animals) {
        this.animals = animals;
    }

    @Lookup
    public CreateAnimalService getCreateAnimalService() {
        return null;
    }

    @PostConstruct
    public void init() {
        animals = getCreateAnimalService().create();
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        Map<String, LocalDate> result = new HashMap<>();
        for (Map.Entry<String, List<Animal>> entry : animals.entrySet()) {
            String str = entry.getKey();
            List<Animal> list = entry.getValue();
            for (Animal animal : list)
                if (animal.getBirthDay().isLeapYear())
                    result.put(str + " " + animal.getName(), animal.getBirthDay());
        }
        return result;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(int n) {
        Map<Animal, Integer> result = new HashMap<>();
        int maxAge = 0;
        Animal maxAnimal = null;
        for (List<Animal> list : animals.values())
            for (Animal animal : list) {
                int age = LocalDate.now().getYear() - animal.getBirthDay().getYear();
                if (age > maxAge) {
                    maxAge = age;
                    maxAnimal = animal;
                }
                if (age > n)
                    result.put(animal, age);
            }
        if (result.isEmpty()) {
            System.out.println("Животные старше n лет отсутствуют; старшее животное:");
            result.put(maxAnimal, maxAge);
        }
        return result;
    }

    @Override
    public Map<String, Integer> findDuplicate() {
        Map<String, Integer> result = new HashMap<>();
        Set<Animal> set = new HashSet<>();
        for (Map.Entry<String, List<Animal>> entry : animals.entrySet()) {
            String str = entry.getKey();
            List<Animal> list = entry.getValue();
            for (Animal animal : list)
                if (!set.add(animal))
                    if (!result.containsKey(str))
                        result.put(str, 1);
                    else
                        result.put(str, result.get(str) + 1);
        }
        return result;
    }

    @Override
    public void printDuplicate() {
        Map<String, Integer> map = findDuplicate();
        if (map.isEmpty()) {
            System.out.println("Дубликаты отсутствуют");
            return;
        }
        System.out.println(map);
    }
}