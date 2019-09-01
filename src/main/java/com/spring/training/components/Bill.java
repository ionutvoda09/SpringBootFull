package com.spring.training.components;

import org.springframework.stereotype.Component;

public class Bill {

    private static final String name = "demobill";

    public String getBill(){
        return name;
    }

    public void billingService(String input){
        System.out.println("========================");
        System.out.println("Create bill for project: "+input);
        System.out.println("========================");
    }

    //Can continue with many other business implementations
}
