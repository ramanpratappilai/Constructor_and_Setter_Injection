Spring Boot Constructor Injection

[ Spring Boot Constructor Injection Example with REST Controller ]

📘 **Overview**

This project demonstrates **Constructor-Based Dependency Injection** in **Spring Boot** using three components:

* `Processor` – a simple component providing system logic
* `Laptop` – depends on `Processor` via constructor injection
* `LaptopController` – exposes a REST API endpoint to start the laptop

🏗️ **Project Structure**

```
spring-constructor-di/
 ├── src/main/java/com/example/constructorinjection/
 │   ├── Processor.java
 │   ├── Laptop.java
 │   ├── LaptopController.java
 │   ├── ConstructorInjectionApplication.java
 └── pom.xml
```

---

### ⚙️ **1. Processor.java**

```java
package com.example.constructorinjection;

import org.springframework.stereotype.Component;

@Component
public class Processor {

    public void showProcessorInfo() {
        System.out.println("Intel i7 Processor is running...");
    }
}
```

---

### 💻 **2. Laptop.java**

```java
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
```

---

### 🌐 **3. LaptopController.java**

```java
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
```

---

### 🧩 **4. ConstructorInjectionApplication.java**

```java
package com.example.constructorinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConstructorInjectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConstructorInjectionApplication.class, args);
    }
}
```

---

### ▶️ **Run the Application**

1. Open the project in **VS Code** or **IntelliJ**.
2. Run the `ConstructorInjectionApplication.java` file.
3. Open your browser or **Postman** and hit:

   ```
   http://localhost:8080/start-laptop
   ```

---

### ✅ **Output**

**In Postman / Browser:**

```
Intel i7 Processor is running...
Laptop started successfully.
```

**In Console Logs:**

```
Intel i7 Processor is running...
```

---

### 🧭 **Flow of Control**

```
Client → LaptopController → Laptop → Processor
```

1. The client sends a GET request to `/start-laptop`.
2. The `LaptopController` receives the request and calls `Laptop.startLaptop()`.
3. `Laptop` uses its injected `Processor` to show processor info.
4. The combined response is returned to the client.

---

### 🔍 **Key Annotations**

| Annotation               | Description                                     |
| ------------------------ | ----------------------------------------------- |
| `@Component`             | Marks a class as a Spring-managed bean.         |
| `@Autowired`             | Enables automatic dependency injection.         |
| `@RestController`        | Handles REST API requests.                      |
| `@GetMapping`            | Maps HTTP GET requests to handler methods.      |
| `@SpringBootApplication` | Entry point that bootstraps the Spring context. |

---

### 💡 **Concept Summary**

* **Constructor Injection** ensures dependencies are provided at object creation time.
* Promotes **immutability**, **testability**, and **cleaner code**.
* Recommended by Spring as the **preferred injection method**.
