package org.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todolist.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
