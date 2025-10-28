package com.example.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    private final Processor processor;

    // ✅ Constructor Injection
    @Autowired
    public Laptop(Processor processor) {
        this.processor = processor;
    }

    public String startLaptop() {
        processor.showProcessorInfo();
        return "Intel i7 Processor is running...\nLaptop started successfully.";
    }
}
