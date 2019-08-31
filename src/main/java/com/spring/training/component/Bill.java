package com.spring.training.component;

import org.springframework.stereotype.Component;

//@Component
public class Bill {

    private static final String name = "demobill";

    public String getBill(){
        return name;
    }
}
