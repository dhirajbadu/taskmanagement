package com.taskmanagement.core.service.impl;

import com.taskmanagement.core.converter.TaskConverter;
import com.taskmanagement.core.model.TaskDTO;
import com.taskmanagement.core.repository.TaskRepository;
import com.taskmanagement.core.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskConverter taskConverter;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        return taskConverter.convertToDto(taskRepository.save(taskConverter.convertToEntity(taskDTO)));
    }

    @Override
    public List<TaskDTO> list() {
        return taskConverter.convertToDtoList(taskRepository.findAll());
    }
}
