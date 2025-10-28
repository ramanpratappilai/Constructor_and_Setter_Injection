package com.example.setterinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentInfo {

    private Course course;

    // ✅ Setter-based Dependency Injection
    @Autowired
    public void setCourse(Course course) {
        this.course = course;
    }

    public String displayStudentInfo() {
        course.showCourseInfo();
        return "Java Programming Course Selected.\nStudent enrolled successfully.";
    }
}
