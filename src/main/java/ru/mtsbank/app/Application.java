package ru.mtsbank.app;

import org.springframework.context.annotation.*;
import ru.mtsbank.animals.Animal;
import ru.mtsbank.service.*;

@Configuration
@ComponentScan("ru")
public class Application {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
            AnimalsRepository ari = context.getBean(AnimalsRepository.class);
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