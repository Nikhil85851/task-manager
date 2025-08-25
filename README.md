# Task Manager API (Spring Boot + H2)
A simple **Task Management REST API** built with **Spring Boot** and **H2 Database**.  
It allows users to create, update, and manage tasks with features like marking tasks as completed and checking for overdue tasks. 

## 🚀 Features
- Create new tasks with title, description, and due date  
- Fetch all tasks  
- Mark a task as completed  
- Get all overdue tasks  
- In-memory H2 database for easy setup and testing  

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database**
- **Maven**

---

## 📂 Project Structure
src
└── main
├── java/com/nikhil/taskmanager
│ ├── Task.java
│ ├── TaskRepository.java
│ ├── TaskService.java
│ ├── TaskController.java
│ └── TaskManagerApplication.java
└── resources
├── application.properties
└── data.sql (optional for sample data)
### Run
1. Install Java 17 and Maven.
2. In terminal:
   ```bash
   mvn spring-boot:run
   ```
3. App runs on `http://localhost:8080`  
   H2 console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:tasks`)

### Endpoints
- `POST /api/tasks`
  ```json
  {
    "title": "Buy milk",
    "description": "From supermarket",
    "dueAt": "2025-08-22T18:00:00"
  }
  ```
- `GET /api/tasks`
- `PUT /api/tasks/{id}/done`
- `GET /api/tasks/overdue`

### Quick cURL
```bash
curl -X POST http://localhost:8080/api/tasks -H "Content-Type: application/json" -d '{"title":"Buy milk","description":"Amul","dueAt":"2025-08-22T18:00:00"}'
curl http://localhost:8080/api/tasks
curl -X PUT http://localhost:8080/api/tasks/1/done
curl http://localhost:8080/api/tasks/overdue
```
