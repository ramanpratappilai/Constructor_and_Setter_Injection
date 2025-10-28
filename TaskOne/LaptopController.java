package com.example.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {

    private final Laptop laptop;

    // ✅ Constructor Injection for Controller
    @Autowired
    public LaptopController(Laptop laptop) {
        this.laptop = laptop;
    }

    @GetMapping("/start-laptop")
    public String startLaptop() {
        return laptop.startLaptop();
    }
}
