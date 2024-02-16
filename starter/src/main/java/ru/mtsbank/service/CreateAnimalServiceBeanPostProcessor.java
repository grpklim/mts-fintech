package ru.mtsbank.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class CreateAnimalServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CreateAnimalServiceImpl) {
            Random random = new Random();
            int i = random.nextInt(4);
            switch (i) {
                case 0 -> ((CreateAnimalServiceImpl) bean).type = AnimalType.CAT;
                case 1 -> ((CreateAnimalServiceImpl) bean).type = AnimalType.DOG;
                case 2 -> ((CreateAnimalServiceImpl) bean).type = AnimalType.SHARK;
                case 3 -> ((CreateAnimalServiceImpl) bean).type = AnimalType.WOLF;
            }
        }
        return bean;
    }
}