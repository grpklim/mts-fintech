package ru.mtsbank.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.exception.CustomExecutionException;
import ru.mtsbank.exception.CustomIllegalArgumentException;
import ru.mtsbank.repository.*;

import java.time.LocalDate;
import java.util.*;

@Component
public class ScheduledTasks {
    @Autowired
    private AnimalsRepository ar;

    @Scheduled(fixedRate = 60000)
    public void callAnimalsRepository() {
        Map<String, LocalDate> map1 = ar.findLeapYearNames();
        for (Map.Entry<String, LocalDate> entry : map1.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
        System.out.println("-----------");
        try {
            Map<Animal, Integer> map2 = ar.findOlderAnimal(34);
            for (Animal animal : map2.keySet())
                System.out.println(animal);
        } catch (CustomIllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println("-----------");
        ar.printDuplicate();
        System.out.println("-----------");
        List<Animal> list = ((AnimalsRepositoryImpl) ar).getAnimals().values().stream().flatMap(Collection::stream).toList();
        try {
            System.out.println(ar.findAverageAge(list));
            System.out.println("-----------");
            System.out.println(ar.findOldAndExpensive(list));
        } catch (CustomIllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println("-----------");
        try {
            System.out.println(ar.findMinConstAnimals(list));
        } catch (CustomExecutionException e) {
            System.out.println(e);
        }
        System.out.println();
    }
}