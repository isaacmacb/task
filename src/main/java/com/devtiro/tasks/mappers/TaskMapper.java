package com.devtiro.tasks.mappers;

import com.devtiro.tasks.entity.TaskEntity;
import com.devtiro.tasks.entity.dto.TaskDto;
import org.springframework.scheduling.config.Task;

public interface TaskMapper {
    TaskEntity fromDto(TaskDto taskDto);
    TaskDto toDto(TaskEntity taskEntity);
}
