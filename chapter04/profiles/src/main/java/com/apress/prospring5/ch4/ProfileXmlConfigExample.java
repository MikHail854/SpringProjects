package com.apress.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;


public class ProfileXmlConfigExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

        /**
         * установка профиля
         * 1) через параметр JVM -Dspring.profiles.active="kindergarten";
         * 2) ctx.getEnvironment().setActiveProfiles("");
         * 3) @Profile
         */

        ctx.getEnvironment().setActiveProfiles("kindergarten");
        //ctx.getEnvironment().setActiveProfiles("highschool");


        ctx.load("classpath:spring/*-config.xml");
        ctx.refresh();

        FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();

        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }

        ctx.close();

    }
}
