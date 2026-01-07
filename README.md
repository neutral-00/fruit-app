# 🍎 Fruit App – Full‑Stack Learning Project

This repository documents the step‑by‑step development of a **full‑stack application** using modern tools and best practices.

The goal is **learning by comparison**:

- First, build everything **manually** (to understand fundamentals)
- Then, rebuild the same app using **JHipster** (to understand automation and conventions)

This repo is intentionally structured as a **learning journey**, not just a finished app.

---

## 🧠 Why this project exists

Most tutorials show only the _happy path_. This project:

- Documents real‑world hiccups
- Explains _why_ things break
- Builds correct mental models (Docker, networking, full‑stack wiring)

By the end, you should be able to:

- Build Angular + Spring Boot apps confidently
- Dockerize frontend, backend, and database
- Understand Docker Compose networking
- Use JHipster **intentionally**, not blindly

---

## 🧩 App Idea (Fruit App)

A simple CRUD application where users can:

- Add a fruit
  - name
  - description
  - image

- View a list of fruits
- Expand a fruit to see details

The app is simple by design, but **architecturally rich**.

---

## 🏗️ Versions

### ✅ fruit‑app v1 – Manual implementation

Built from scratch to understand:

- Angular frontend
- Spring Boot backend
- PostgreSQL
- Docker & Docker Compose

### ⚡ fruit‑app v2 – JHipster implementation

Rebuild the same app using:

- JHipster Monolith
- Angular + Spring Boot
- PostgreSQL
- Generated Docker Compose

This allows a **clear comparison** between manual and automated approaches.

---

## 🛠 Tech Stack

### Frontend

- Angular 21.x
- Tailwind CSS
- Angular Material
- pnpm

### Backend

- Java 21
- Spring Boot 3.x
- REST APIs

### Database

- PostgreSQL 17
- pgAdmin 4.x

### DevOps

- Docker Desktop
- Docker Compose

---

## 🌿 Branching Strategy

This repo uses **progressive branches**. Each branch:

- Is runnable
- Represents a learning milestone

```text
main
 ├── v1-backend-basic
 ├── v1-frontend-basic
 ├── v1-docker-compose
 ├── v1-complete
 ├── v2-jhipster-init
 ├── v2-jhipster-entity
 └── v2-complete
```

---

## 📁 Repository Structure (planned)

```text
fruit-app/
  docs/
  fruit-app-v1/
    frontend/
    backend/
    docker-compose.yml
  fruit-app-v2/
    (JHipster generated)
```

---

## 📚 Documentation

All learning notes live under `/docs` and are meant to be read **in order**.

### Initial documents

- `01-project-overview.md`
- `02-tech-stack.md`

More docs will be added as we progress.

---

## 🚀 How to use this repo

- Checkout branches sequentially
- Read the docs for that step
- Run the app
- Break things
- Learn why

---

## 🧭 Roadmap (high level)

1. Backend skeleton (Spring Boot)
2. Frontend skeleton (Angular)
3. Frontend ↔ Backend integration
4. PostgreSQL integration
5. Dockerizing backend
6. Dockerizing frontend
7. Docker Compose
8. File upload
9. v1 summary
10. Rebuild with JHipster

---

## 📌 Final note

This project is **intentionally incremental**.

> We value understanding over speed.

If you follow along step by step, you’ll not only know _how_ things work — you’ll know _why_.

Happy building 🚀
