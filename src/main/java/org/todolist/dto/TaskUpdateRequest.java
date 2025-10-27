package org.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskUpdateRequest {

    @NotBlank(message = "Task description is required")
    private String description;
    private Long priority;

}