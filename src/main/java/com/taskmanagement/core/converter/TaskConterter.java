package com.taskmanagement.core.converter;

import com.taskmanagement.core.entity.TaskEntity;
import com.taskmanagement.core.model.TaskDTO;
import com.taskmanagement.core.model.TaskGroupDTO;
import com.taskmanagement.core.repository.EmployeeRepository;
import com.taskmanagement.core.repository.TaskGroupRepository;
import com.taskmanagement.core.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskConterter implements IConvertable<TaskEntity, TaskDTO> {

    @Autowired
    private EmployeeConterver employeeConterver;

    @Autowired
    private TaskGroupConterver taskGroupConterver;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskGroupRepository taskGroupRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskEntity convertToEntity(TaskDTO dto) {
        return null;
    }

    @Override
    public TaskDTO convertToDto(TaskEntity entity) {

        if(entity == null) {
            return null;
        }

        TaskDTO dto = new TaskDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setTimeSpend(entity.getTimeSpend());
        dto.setAssignee(employeeConterver.convertToDto(entity.getAssignee()));
        dto.setTaskGroup(taskGroupConterver.convertToDto(entity.getTaskGroup()));
        dto.setSubTask(convertToDto(entity.getSubTask()));

        return dto;
    }

    @Override
    public TaskEntity copyConvertToEntity(TaskDTO dto, TaskEntity entity) {
        if(dto == null || entity == null) {
            return null;
        }

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setTimeSpend(dto.getTimeSpend());
        if(dto.getAssignee() != null) entity.setAssignee(employeeRepository.findById(dto.getAssignee().getId()).get());
        if(dto.getTaskGroup() != null) entity.setTaskGroup(taskGroupRepository.findById(dto.getTaskGroup().getId()).get());
        if(dto.getSubTask() != null) entity.setSubTask(taskRepository.findById(dto.getSubTask().getId()).get());


        return entity;
    }

    @Override
    public List<TaskDTO> convertToDtoList(List<TaskEntity> entities) {
        return entities.parallelStream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskEntity> convertToEntityList(List<TaskDTO> dtoList) {
        return dtoList.parallelStream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
