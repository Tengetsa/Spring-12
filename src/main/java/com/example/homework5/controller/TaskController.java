package com.example.homework5.controller;

import com.example.homework5.service.FileGateway;
import com.example.homework5.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final FileGateway fileGateway;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        task.setLocalDateTime(LocalDateTime.now());
        fileGateway.writeToFile(task.getDescription() + ".txt", task.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
