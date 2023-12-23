package ru.mtsbank.main;

import ru.mtsbank.animals.Animal;
import ru.mtsbank.service.*;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl casi = new CreateAnimalServiceImpl();
        SearchServiceImpl ssi = new SearchServiceImpl();
        Animal[] arr = casi.createAnimal(12);
        String[] sarr = ssi.findLeapYearNames(arr);
        for (String x : sarr)
            System.out.println(x);
        System.out.println();
        Animal[] aarr = ssi.findOlderAnimal(arr, 34);
        for (Animal x : aarr)
            System.out.println(x);
        System.out.println();
        ssi.findDuplicate(arr);
    }
}