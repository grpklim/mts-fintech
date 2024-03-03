package ru.mtsbank.repository;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;
import ru.mtsbank.animals.*;
import ru.mtsbank.service.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        animals.values().stream().flatMap(Collection::stream).filter(animal -> animal.getBirthDay().isLeapYear())
                .forEach(animal -> result.put(animal.getType() + " " + animal.getName(), animal.getBirthDay()));
        return result;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(int n) {
        Map<Animal, Integer> result = new HashMap<>();
        animals.values().stream().flatMap(Collection::stream).filter(animal -> animal.getAge() > n)
                .forEach(animal -> result.put(animal, animal.getAge()));
        if (result.isEmpty()) {
            System.out.println("Животные старше n лет отсутствуют; старшее животное:");
            animals.values().stream().flatMap(Collection::stream)
                    .sorted((a1, a2) -> Integer.compare(a2.getAge(), a1.getAge())).limit(1)
                    .forEach(animal -> result.put(animal, animal.getAge()));
        }
        return result;
    }

    @Override
    public Map<String, List<Animal>> findDuplicate() {
        Set<Animal> set = new HashSet<>();
        return animals.values().stream().flatMap(Collection::stream).filter(animal -> !set.add(animal))
                .collect(Collectors.groupingBy(Animal::getType));
    }

    @Override
    public void printDuplicate() {
        Map<String, List<Animal>> map = findDuplicate();
        if (map.isEmpty()) {
            System.out.println("Дубликаты отсутствуют");
            return;
        }
        System.out.println(map);
    }

    @Override
    public double findAverageAge(List<Animal> list) {
        return list.stream().mapToInt(Animal::getAge).average().getAsDouble();
    }

    @Override
    public List<Animal> findOldAndExpensive(List<Animal> list) {
        List<Animal> pets = list.stream().filter(animal -> animal instanceof Cat || animal instanceof Dog).toList();
        double avCost = pets.stream().mapToDouble(animal -> animal.getCost().doubleValue()).average().getAsDouble();
        return pets.stream().filter(animal -> (animal.getAge() > 5) && (animal.getCost().doubleValue() > avCost))
                .sorted(Comparator.comparing(Animal::getBirthDay)).toList();
    }

    @Override
    public List<String> findMinConstAnimals(List<Animal> list) {
        List<Animal> pets = list.stream().filter(animal -> animal instanceof Cat || animal instanceof Dog).toList();
        return pets.stream().sorted(Comparator.comparing(Animal::getCost)).limit(3)
                .sorted((a1, a2) -> a2.getName().compareTo(a1.getName())).map(Animal::getName).toList();
    }
}