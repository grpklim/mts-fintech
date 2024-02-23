package ru.mtsbank.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.repository.AnimalsRepository;

import java.time.LocalDate;
import java.util.Map;

@Component
public class ScheduledTasks {
    @Autowired
    private AnimalsRepository ar;

    @Scheduled(fixedRate = 60000)
    public void callAnimalsRepository() {
        Map<String, LocalDate> map1 = ar.findLeapYearNames();
        for (String str : map1.keySet())
            System.out.println(str + " " + map1.get(str));
        System.out.println("-----------");
        Map<Animal, Integer> map2 = ar.findOlderAnimal(34);
        for (Animal animal : map2.keySet())
            System.out.println(animal);
        System.out.println("-----------");
        ar.printDuplicate();
        System.out.println();
    }
}