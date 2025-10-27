package org.todolist.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.todolist.dto.TaskUpdateRequest;
import org.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/todoList")
@RequiredArgsConstructor
class TaskController {

    private final TaskService service;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id,  @Valid @RequestBody TaskUpdateRequest request) {
        return service.updateTask(id, request);
    }
}