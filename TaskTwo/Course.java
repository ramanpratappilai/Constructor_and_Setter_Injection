package com.example.setterinjection;

import org.springframework.stereotype.Component;

@Component
public class Course {

    public void showCourseInfo() {
        System.out.println("Java Programming Course Selected.");
    }
}
