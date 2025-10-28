package com.example.constructorinjection;

import org.springframework.stereotype.Component;

@Component
public class Processor {

    public void showProcessorInfo() {
        System.out.println("Intel i7 Processor is running...");
    }
}
