# Task Manager API (Spring Boot + H2)

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
