package com.nikhil.taskmanager;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task createTask(CreateTaskRequest req) {
        Task t = new Task(req.getTitle(), req.getDescription(), req.getDueAt());
        return repo.save(t);
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task markDone(Long id) {
        Task t = repo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        t.setCompleted(true);
        return repo.save(t);
    }

    public List<Task> overdue() {
        return repo.findByCompletedFalseAndDueAtBefore(LocalDateTime.now());
    }
}
