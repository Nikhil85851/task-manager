package com.nikhil.taskmanager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Task> create(@Valid @RequestBody CreateTaskRequest req) {
        return ResponseEntity.ok(service.createTask(req));
    }

    @GetMapping
    public ResponseEntity<List<Task>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<Task> done(@PathVariable Long id) {
        return ResponseEntity.ok(service.markDone(id));
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Task>> overdue() {
        return ResponseEntity.ok(service.overdue());
    }
}
