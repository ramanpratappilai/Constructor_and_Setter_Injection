package com.example.setterinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentInfo studentInfo;

    // ✅ Setter Injection for Controller
    @Autowired
    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    @GetMapping("/enroll-student")
    public String enrollStudent() {
        return studentInfo.displayStudentInfo();
    }
}
