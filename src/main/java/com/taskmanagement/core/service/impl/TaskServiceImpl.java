package com.taskmanagement.core.service.impl;

import com.taskmanagement.core.converter.TaskConverter;
import com.taskmanagement.core.entity.TaskEntity;
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
    public TaskDTO getById(Long taskId) {
        return taskConverter.convertToDto(taskRepository.findById(taskId).orElse(null));
    }

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        return taskConverter.convertToDto(taskRepository.save(taskConverter.convertToEntity(taskDTO)));
    }

    @Override
    public List<TaskDTO> list() {
        return taskConverter.convertToDtoList(taskRepository.findAll());
    }

    @Override
    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskDTO update(TaskDTO taskDTO) {
        TaskEntity taskEntity = taskRepository.findById(taskDTO.getId()).orElse(null);
        if(taskEntity == null){
            return null;
        }
        return taskConverter.convertToDto(taskRepository.save(taskConverter.copyConvertToEntity(taskDTO, taskEntity)));
    }
}
