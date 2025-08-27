package com.devtiro.tasks.entity.dto;

import com.devtiro.tasks.entity.Enum.TaskPriority;
import com.devtiro.tasks.entity.Enum.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status

        )
  {
}
