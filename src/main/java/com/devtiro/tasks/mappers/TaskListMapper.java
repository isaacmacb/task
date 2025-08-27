package com.devtiro.tasks.mappers;

import com.devtiro.tasks.entity.TaskList;
import com.devtiro.tasks.entity.dto.TaskListDto;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
