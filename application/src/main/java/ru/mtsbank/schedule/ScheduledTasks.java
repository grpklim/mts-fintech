package ru.mtsbank.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.repository.AnimalsRepository;

@Component
public class ScheduledTasks {
    @Autowired
    AnimalsRepository ar;

    @Scheduled(fixedRate = 60000)
    public void callAnimalsRepository() {
        for (String name : ar.findLeapYearNames())
            System.out.println(name);
        System.out.println("-----------");
        for (Animal animal : ar.findOlderAnimal(34))
            System.out.println(animal);
        System.out.println("-----------");
        ar.printDuplicate();
        System.out.println();
    }
}