package ru.mtsbank.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.exception.CustomException;
import ru.mtsbank.exception.CustomIllegalArgumentException;
import ru.mtsbank.repository.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ScheduledTasks {
    @Autowired
    private AnimalsRepository ar;

    private List<Animal> listAsArgument;

    @PostConstruct
    public void init() {
        listAsArgument = ((AnimalsRepositoryImpl) ar).getAnimals().values().stream().flatMap(Collection::stream).toList();
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Дочерний поток 1");
                while (true) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " --- Метод printDuplicate");
                    ar.printDuplicate();
                }
            }
        });
        es.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Дочерний поток 2");
                while (true) {
                    try {
                        Thread.sleep(13333);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " --- Метод findAverageAge");
                    try {
                        System.out.println("\t" + ar.findAverageAge(listAsArgument));
                    } catch (CustomIllegalArgumentException e) {
                        System.out.println(e);
                    }
                }
            }
        });
    }

    @Scheduled(fixedRate = 60000)
    public void callAnimalsRepository() {
        Thread curThread = Thread.currentThread();
        curThread.setName("Главный поток");
        System.out.println(curThread.getName() + " --- Метод findLeapYearNames");
        Map<String, LocalDate> map1 = ar.findLeapYearNames();
        for (Map.Entry<String, LocalDate> entry : map1.entrySet())
            System.out.println("\t" + entry.getKey() + " " + entry.getValue());
        try {
            System.out.println(curThread.getName() + " --- Метод findOlderAnimal");
            Map<Animal, Integer> map2 = ar.findOlderAnimal(34);
            for (Animal animal : map2.keySet())
                System.out.println("\t" + animal);
            System.out.println(curThread.getName() + " --- Метод findOldAndExpensive");
            System.out.println("\t" + ar.findOldAndExpensive(listAsArgument));
            System.out.println(curThread.getName() + " --- Метод findMinConstAnimals");
            System.out.println("\t" + ar.findMinConstAnimals(listAsArgument));
        } catch (CustomIllegalArgumentException | CustomException e) {
            System.out.println(e);
        }
    }
}