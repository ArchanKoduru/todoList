package org.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.todolist.dto.TaskUpdateRequest;
import org.todolist.exceptions.TaskNotFoundException;
import org.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.todolist.entity.Task;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public ResponseEntity<?> updateTask(Long id, TaskUpdateRequest request) {
        // Validate input
        Task existingTask = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));


        // Update task and save
        Task updatedTask = Task.builder()
                .id(existingTask.getId())
                .description(request.getDescription())
                .priority(request.getPriority())
                .build();
        repository.save(updatedTask);

        // Return success response
        return ResponseEntity.ok(request);
    }
}