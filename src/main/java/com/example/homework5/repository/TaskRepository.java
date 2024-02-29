package com.example.homework5.repository;

import com.example.homework5.model.Task;
import com.example.homework5.status.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * Получения список задач с определенным статусом.
     */
    List<Task> getTasksByStatus(TaskStatus status);
}