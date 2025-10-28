🧩 **Spring Boot Setter Injection with Controller**

### 🏗️ **Project Structure**

```
spring-setter-di/
 ├── src/main/java/com/example/setterinjection/
 │   ├── Course.java
 │   ├── StudentInfo.java
 │   ├── StudentController.java
 │   ├── SetterInjectionApplication.java
 └── pom.xml
```
### **1️⃣ Course.java**

```java
package com.example.setterinjection;

import org.springframework.stereotype.Component;

@Component
public class Course {

    public void showCourseInfo() {
        System.out.println("Java Programming Course Selected.");
    }
}
```
### **2️⃣ StudentInfo.java**

```java
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
```
### **3️⃣ StudentController.java**

```java
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
```
### **4️⃣ SetterInjectionApplication.java**

```java
package com.example.setterinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SetterInjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SetterInjectionApplication.class, args);
    }
}
```
### **▶️ Run & Test**

1. Run the application using **VS Code** or **IntelliJ**.
2. Open your browser or **Postman** and hit:

   ```
   http://localhost:8080/enroll-student
   ```

### **✅ Output (in Postman / Browser)**

```
Java Programming Course Selected.
Student enrolled successfully.
```

**Console Output**

```
Java Programming Course Selected.
```

### **🧠 Flow of Control**

```
Client → StudentController → StudentInfo → Course
```

| Layer      | Class                        | Purpose                        |
| ---------- | ---------------------------- | ------------------------------ |
| Component  | `Course`                     | Provides the course info       |
| Component  | `StudentInfo`                | Depends on Course (via setter) |
| Controller | `StudentController`          | REST endpoint for enrollment   |
| Main App   | `SetterInjectionApplication` | Bootstraps the app             |
