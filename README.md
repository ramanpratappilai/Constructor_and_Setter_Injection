## 🧩 **Spring Boot – Constructor and Setter Injection**

### 📘 **Overview**

This project demonstrates **two types of Dependency Injection** in Spring Boot:

1. **Constructor Injection** [ available Folder TaskOne ]
2. **Setter Injection** [ available Folder TaskTwo ]

Each example shows how Spring automatically injects one bean into another using `@Autowired`.

---

### 🧠 **1️⃣ Constructor Injection Example**

**Classes:**

* `Processor` → Prints “Intel i7 Processor is running...”
* `Laptop` → Depends on `Processor` (injected via constructor)
* `LaptopController` → REST controller exposing `/start-laptop`

**Endpoint:**

```
GET http://localhost:8080/start-laptop
```

**Output:**

```
Intel i7 Processor is running...
Laptop started successfully.
```

---

### 🧠 **2️⃣ Setter Injection Example**

**Classes:**

* `Course` → Prints “Java Programming Course Selected.”
* `StudentInfo` → Depends on `Course` (injected via setter method)
* `StudentController` → REST controller exposing `/enroll-student`

**Endpoint:**

```
GET http://localhost:8080/enroll-student
```

**Output:**

```
Java Programming Course Selected.
Student enrolled successfully.
```

---

### ⚙️ **Concept Summary**

| Type                      | Injection Point        | Example            | Advantage                        |
| ------------------------- | ---------------------- | ------------------ | -------------------------------- |
| **Constructor Injection** | During object creation | Laptop–Processor   | Promotes immutability            |
| **Setter Injection**      | After object creation  | StudentInfo–Course | Flexible, allows reconfiguration |

---

### ▶️ **Run**

1. Run the Spring Boot application.
2. Test both endpoints in Postman or browser.
