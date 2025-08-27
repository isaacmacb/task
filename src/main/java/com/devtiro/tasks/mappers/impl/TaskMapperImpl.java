package com.devtiro.tasks.mappers.impl;

import com.devtiro.tasks.entity.TaskEntity;
import com.devtiro.tasks.entity.dto.TaskDto;
import com.devtiro.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskEntity fromDto(TaskDto taskDto) {
        return new TaskEntity(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.status(),
                taskDto.priority(),
                null,  // taskList
                null,  // created
                null   // updated
        );
    }

    @Override
    public TaskDto toDto(TaskEntity taskEntity) {
        return new TaskDto(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getDueDate(),
                taskEntity.getPriority(),
                taskEntity.getStatus()
        );
    }
}
