# TaskFlow

A full-stack project and task management system built with Spring Boot and PostgreSQL.

## 🚀 Features

- Create, update, and delete Projects
- Assign Tasks to Users
- Track Task status and priority
- Relational database structure (Projects ↔ Tasks ↔ Users)

## 📦 Tech Stack

- Java + Spring Boot
- PostgreSQL
- JPA/Hibernate
- RESTful API
- VS Code / IntelliJ

## 🧪 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/your-username/taskflow.git
cd taskflow

### 2. Set up PostgreSQL
Make sure PostgreSQL is installed and running.

Create a new database (e.g., taskflow_db) and update your credentials in application.properties.

### 3. Run the App
./mvnw spring-boot:run
The app will run at http://localhost:8080.

### 4. API Endpoints
Use a tool like Postman or Thunder Client to hit endpoints like:

POST /projects/testdb – Add a new project

GET /projects – Get all projects

POST /tasks/testdb – Add a task

GET /tasks – Get all tasks

### 📁 Folder Structure
src
├── main
│   ├── java
│   │   └── com.taskflow
│   │       ├── controller
│   │       ├── model
│   │       ├── repository
│   │       └── service
│   └── resources
│       └── application.properties

### ✍️ Author
Zain Morshed
https://www.linkedin.com/in/zain-morshed/