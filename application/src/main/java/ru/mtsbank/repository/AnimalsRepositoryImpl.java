package ru.mtsbank.repository;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.service.CreateAnimalService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {
    private Animal[] animals;

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    @Lookup
    public CreateAnimalService getCreateAnimalService() {
        return null;
    }

    @PostConstruct
    public void init() {
        animals = new Animal[10];
        for (int i = 0; i < 10; i++)
            animals[i] = getCreateAnimalService().create();
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
        Set<Animal> set = new HashSet<>();
        Set<Animal> result = new HashSet<>();
        for (Animal animal : animals)
            if (!set.add(animal))
                result.add(animal);
        return result;
    }

    @Override
    public void printDuplicate() {
        Set<Animal> animalSet = findDuplicate();
        if (animalSet.isEmpty()) {
            System.out.println("Без дубликатов");
            return;
        }
        for (Animal animal : animalSet)
            System.out.println(animal);
    }
}