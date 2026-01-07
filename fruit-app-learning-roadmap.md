# 🍎 Fruit App – Learning Roadmap

We’ll build the **same app twice**:

- **fruit-app v1** → Manual (Angular + Spring Boot + PostgreSQL + Docker)
- **fruit-app v2** → JHipster (Monolith first)

This lets you **compare approaches**, not just follow one.

---

## 🗂 GitHub Repository Strategy

### Repository name

```
https://github.com/neutral-00/fruit-app
```

### Why single repo?

- Easier comparison
- Clear evolution
- Cleaner documentation
- Industry-style branching

---

## 🌿 Branching Strategy (important)

We’ll use **progressive branches**, not feature branches.

```
main
 ├── docs
 ├── v1-backend-basic
 ├── v1-frontend-basic
 ├── v1-docker-compose
 ├── v1-file-upload
 ├── v1-complete
 ├── v2-jhipster-init
 ├── v2-jhipster-entity
 ├── v2-jhipster-docker
 └── v2-complete
```

Each branch:

- Builds on the previous
- Is runnable
- Documents one learning milestone

---

## 📁 Repo Folder Structure (baseline)

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

# 🚀 FRUIT-APP V1 (Manual Implementation)

> Goal: **Understand everything by building it yourself**

---

## 🧩 V1 – Step-by-step Implementation Plan

---

### ✅ Step 0: Repo bootstrap (branch: `main`)

**Tasks**

- Create GitHub repo
- Add README.md
- Add `/docs` folder
- Describe app idea & roadmap

**Docs**

- `docs/01-project-overview.md`
- `docs/02-tech-stack.md`

---

### ✅ Step 1: Backend skeleton (branch: `v1-backend-basic`)

**Tech**

- Spring Boot
- Java 21
- REST API

**Features**

- `/api/health`
- `/api/fruits` (GET, POST)

**Deliverables**

- Fruit entity (id, name, description)
- In-memory DB (H2) first

**Docs**

- `docs/03-backend-setup.md`
- `docs/04-rest-api-design.md`

---

### ✅ Step 2: Frontend skeleton (branch: `v1-frontend-basic`)

**Tech**

- Angular
- Tailwind
- Angular Material

**Features**

- Add fruit form
- List fruits
- Collapsible cards

**Docs**

- `docs/05-frontend-setup.md`
- `docs/06-angular-ui-design.md`

---

### ✅ Step 3: Connect frontend ↔ backend (branch: `v1-frontend-backend-integration`)

**Focus**

- HTTP services
- Environment configs
- CORS

**Docs**

- `docs/07-frontend-backend-integration.md`

---

### ✅ Step 4: PostgreSQL integration (branch: `v1-postgres`)

**Tech**

- PostgreSQL 17
- JPA
- Flyway (optional but recommended)

**Focus**

- Replace H2
- Externalized config
- Local DB first

**Docs**

- `docs/08-postgresql-setup.md`

---

### ✅ Step 5: Dockerize backend (branch: `v1-backend-docker`)

**Focus**

- Dockerfile for Spring Boot
- Profiles
- `0.0.0.0` binding

**Docs**

- `docs/09-backend-docker.md`

---

### ✅ Step 6: Dockerize frontend (branch: `v1-frontend-docker`)

**Focus**

- Angular dev container
- Port exposure
- API URLs

**Docs**

- `docs/10-frontend-docker.md`

---

### ✅ Step 7: Docker Compose (branch: `v1-docker-compose`)

**Services**

- frontend
- backend
- postgres
- pgadmin

**Key Learning**

- Service-name networking
- Volumes
- Env vars

**Docs**

- `docs/11-docker-compose.md`
- `docs/12-docker-networking.md`

---

### ✅ Step 8: File upload (branch: `v1-file-upload`)

**Focus**

- Multipart upload
- Image storage (volume-mounted)
- Serve images

**Docs**

- `docs/13-file-upload.md`

---

### ✅ Step 9: v1 complete (branch: `v1-complete`)

**Deliverable**

- Fully working fruit app
- Manual stack
- Well-documented pitfalls

**Docs**

- `docs/14-v1-summary.md`
- `docs/15-what-we-learned.md`

---

# ⚡ FRUIT-APP V2 (JHipster)

> Goal: **See how much JHipster automates — and why**

---

## 🧩 V2 – Step-by-step Implementation Plan

---

### ✅ Step 10: JHipster init (branch: `v2-jhipster-init`)

**Choices**

- Monolith
- Angular
- PostgreSQL
- JWT auth
- Docker support

**Docs**

- `docs/16-jhipster-introduction.md`
- `docs/17-jhipster-init.md`

---

### ✅ Step 11: Fruit entity via JHipster (branch: `v2-jhipster-entity`)

**Generate**

- Fruit entity
- REST
- Angular UI
- DB migration

**Docs**

- `docs/18-jhipster-entity.md`

---

### ✅ Step 12: Docker Compose with JHipster (branch: `v2-jhipster-docker`)

**Focus**

- Generated compose files
- Profiles
- Networking correctness

**Docs**

- `docs/19-jhipster-docker.md`

---

### ✅ Step 13: Compare v1 vs v2 (branch: `v2-complete`)

**Analysis**

- What JHipster saved
- What it enforces
- What’s customizable

**Docs**

- `docs/20-v1-vs-v2-comparison.md`
- `docs/21-when-to-use-jhipster.md`

---

## 🧠 Why this approach is excellent

- You **don’t treat JHipster as magic**
- You understand _why_ it does what it does
- You build reusable mental models
- You end up with:
  - A reference repo
  - A teaching repo
  - A real portfolio project

This is exactly how **senior engineers learn frameworks**.

---

## ✅ Next concrete action (very small)

I recommend we start with:

### 👉 Step 0

- Create repo: `fruit-app`
- Write:
  - README.md
  - `docs/01-project-overview.md`

If you want, next I can:

- Draft the **README.md**
- Create the **docs folder structure**
- Write **Step 1 backend skeleton plan**
- Or help you decide **API contracts first**

Just say where you want to start 🍏
