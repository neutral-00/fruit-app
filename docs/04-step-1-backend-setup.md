# ✅ Step 1: Backend Skeleton Setup (Spring Boot + H2)

## Project Metadata

- Parent branch: `main`
- **Branch**: `v1-backend-basic`

---

## 🎯 Goal of this step

In this step, we build a **minimal but real Spring Boot backend** for the Fruit App.

The focus is on:

- Project structure
- REST API design
- Basic persistence using **H2 (in-memory database)**

We intentionally avoid Docker and PostgreSQL here to:

- Keep feedback loops fast
- Focus on backend fundamentals
- Make later transitions (PostgreSQL, Docker) easier to understand

---

## 🧠 Why H2 first?

Using H2 allows us to:

- Avoid external dependencies
- Prototype entities and APIs quickly
- Validate JPA mappings early

Later, in Step 4, we will **replace H2 with PostgreSQL** with minimal code changes.

---

## 📁 Backend Location

All backend code for v1 lives under:

```text
fruit-app-v1/backend/
```

---

## 🛠 Tech Stack (Backend – v1)

- Java 21
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

## 🚀 Project Initialization

### Option 1: Spring Initializr (recommended)

Create a Spring Boot project with:

- **Project**: Maven
- **Language**: Java
- **Spring Boot**: 3.5.9
- **Group**: `com.neutral`
- **Artifact**: `backend`
- **Name**: fruit-app
- **Description**: Backend for fruit-app
- **Package Name**: com.neutral.fruit
- **Configuration**: YAML
- **Packaging**: Jar
- **Java**: 21

### Dependencies

- Spring Web
- Spring Data JPA
- H2 Database

Unzip the project into:

```text
fruit-app-v1/backend/
```

---

## 📦 Basic Package Structure

Recommended structure:

```text
com.neutral.fruit
 ├── FruitAppApplication.java
 ├── domain
 │    └── Fruit.java
 ├── repository
 │    └── FruitRepository.java
 ├── service
 │    └── FruitService.java
 ├── controller
 │    └── FruitController.java
 └── config
```

This follows **standard Spring Boot conventions** and keeps concerns separated.

---

## 🍎 Fruit Domain Model

### Fruit Entity

Initial fields:

- `id` (Long)
- `name` (String)
- `description` (String)

This is intentionally minimal. We will extend it later (image, timestamps).

In the `pom.xml` add the following dependency for validation

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

Create Fruit domain as shown below:

```java
package com.neutral.fruit.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


```

** Note **

> We use UUIDs to avoid ID collisions and to better align with distributed systems.

Create FruitRepository as shown below

```java
package com.neutral.fruit.repository;

import com.neutral.fruit.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, UUID> {
}

```

And add **FruitService**

```java
@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }
}
```

Create FruitController as shown below

```java
package com.neutral.fruit.controller;

import com.neutral.fruit.domain.Fruit;
import com.neutral.fruit.service.FruitService;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/fruits")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        return ResponseEntity.ok(fruits);
    }

    @PostMapping
    public ResponseEntity<Fruit> createFruit(@Validated(Default.class) @RequestBody Fruit fruit) {
        Fruit savedFruit = fruitService.saveFruit(fruit);
        return ResponseEntity.ok(savedFruit);
    }
}

```

---

### 💡 “Why no DTOs yet?”

> DTOs are intentionally skipped in v1 to keep the backend simple. JHipster will introduce DTOs later.

## 🗄 H2 Configuration

Add the following to `application.yml`:

```yaml
spring:
  application: name:fruit-app
  profiles:
    active: dev

  datasource:
    url: jdbc:h2:mem:fruit_db
    driver-class-name: org.h2.Driver
    username: sa
    password:

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    defer-datasource-initialization: true
    database-platform: org.hibernate.dialect.H2Dialect

  h2:
    console:
      enabled: true
      path: /h2-console

  sql:
    init:
      mode: always
```

Add `src/main/resouces/data.sql` with the below content

```sql
INSERT INTO fruit (id, name, description) VALUES
('550e8400-e29b-41d4-a716-446655440001', 'Apple', 'Red, crisp fruit rich in fiber.'),
('550e8400-e29b-41d4-a716-446655440002', 'Banana', 'Yellow curved tropical fruit high in potassium.'),
('550e8400-e29b-41d4-a716-446655440003', 'Orange', 'Citrus fruit packed with vitamin C.'),
('550e8400-e29b-41d4-a716-446655440004', 'Mango', 'Sweet juicy stone fruit from tropics.'),
('550e8400-e29b-41d4-a716-446655440005', 'Strawberry', 'Small red berry with seeds on surface.');

```

Note that we set `spring.jpa.defer-datasource-initialization` to true, so that DDLa are executed first.

### H2 Console

Once the app is running, you can access:

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:fruit_db
```

---

## 🌐 REST API Design

### Health Check

We need to add actuators. Add the below dependency in pom.xml

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Next, add the below properties in `application-dev.yaml`

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info
  endpoint:
    health:
      show-details: always
```

To enable actuators only in dev update `application.yaml`, add the below section

```yaml
spring:
  application: name:fruit-app
  profiles:
    active: dev
```

Now you can hit

```http
http://localhost:8080/actuator/health
```

Response:

```json
{
  "status": "UP"
}
```

---

### Fruit APIs

#### Get all fruits

```bash
curl http://localhost:8080/api/fruits
```

---

#### Create a fruit

```http
POST /api/fruits
Content-Type: application/json
```

Request body:

```json
{
  "name": "Apple",
  "description": "Red and sweet"
}
```

---

## 📌 What we intentionally did NOT do

- No Docker
- No PostgreSQL
- No security
- No file upload

These will be introduced incrementally in later steps.

---

## ✅ Completion Checklist

- [x] Spring Boot app starts successfully
- [x] `/api/health` returns UP
- [x] `/api/fruits` GET works
- [x] `/api/fruits` POST works
- [x] H2 console accessible

---

## 🧭 Next Step

👉 **Step 2: Frontend Skeleton (Angular)**

Once the backend APIs are stable, we will create the Angular frontend and start wiring the two together.

---

## 🧠 What we learned in this step

- How to structure a Spring Boot backend
- Why starting with H2 accelerates learning
- How to design REST APIs before UI

---

**Status**: Completed ✅
