package com.nikhil.taskmanager;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompletedFalseAndDueAtBefore(LocalDateTime dateTime);
}
