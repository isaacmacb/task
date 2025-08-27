package com.devtiro.tasks.mappers.impl;

import com.devtiro.tasks.entity.TaskList;
import com.devtiro.tasks.entity.TaskEntity;
import com.devtiro.tasks.entity.dto.TaskListDto;
import com.devtiro.tasks.mappers.TaskListMapper;
import com.devtiro.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        if (taskListDto == null) return null;

        return new TaskList(
                taskListDto.id(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList()
                        ).orElse(null),
                taskListDto.title(),
                taskListDto.description(),
                LocalDateTime.now(), // created
                LocalDateTime.now()  // updated
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        if (taskList == null) return null;

        var tasksDto = Optional.ofNullable(taskList.getTaskEntities())
                .map(taskEntities -> taskEntities.stream()
                        .map(taskMapper::toDto)
                        .toList()
                ).orElse(null);

        int count = taskList.getTaskEntities() != null ? taskList.getTaskEntities().size() : 0;

        double progress = 0.0;
        if (taskList.getTaskEntities() != null && !taskList.getTaskEntities().isEmpty()) {
            long completed = taskList.getTaskEntities().stream()
                    .filter(task -> task.getStatus() != null && task.getStatus().name().equals("CLOSED"))
                    .count();
            progress = (double) completed / taskList.getTaskEntities().size();
        }

        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                count,
                progress,
                tasksDto
        );
    }
}
