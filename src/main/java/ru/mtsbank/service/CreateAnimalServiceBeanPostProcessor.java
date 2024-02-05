package ru.mtsbank.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Configuration
public class CreateAnimalServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            TempAnnoAnimalType anno = field.getAnnotation(TempAnnoAnimalType.class);
            if (anno != null) {
                field.setAccessible(true);
                Random random = new Random();
                int i = random.nextInt(4);
                switch (i) {
                    case 0 -> ReflectionUtils.setField(field, bean, AnimalType.CAT);
                    case 1 -> ReflectionUtils.setField(field, bean, AnimalType.DOG);
                    case 2 -> ReflectionUtils.setField(field, bean, AnimalType.SHARK);
                    case 3 -> ReflectionUtils.setField(field, bean, AnimalType.WOLF);
                }
            }
        }
        return bean;
    }
}