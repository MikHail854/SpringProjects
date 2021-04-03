package com.apress.prospring5.ch4.config;

import com.apress.prospring5.ch4.Food;
import com.apress.prospring5.ch4.FoodProviderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class ProfileJavaConfigExample {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(
                HighschoolConfig.class,
                KindergartenConfig.class);

        FoodProviderService foodProviderService =
                ctx.getBean("foodProviderService", FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();

        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }

        ctx.close();

    }
}
