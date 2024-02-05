package ru.mtsbank.main;

import org.springframework.context.annotation.*;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.service.*;

@Configuration
@ComponentScan("ru")
public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class)) {
            CreateAnimalService casi = context.getBean(CreateAnimalService.class);
            AnimalsRepository ari = context.getBean(AnimalsRepository.class);
            Animal[] animals = ari.getAnimals();
            for (int i = 0; i < 10; i++) {
                animals[i] = casi.create();
                casi = context.getBean(CreateAnimalServiceImpl.class);
            }
            for (String name : ari.findLeapYearNames())
                System.out.println(name);
            System.out.println("-----------");
            for (Animal animal : ari.findOlderAnimal(34))
                System.out.println(animal);
            System.out.println("-----------");
            ari.findDuplicate();
        }
    }
}