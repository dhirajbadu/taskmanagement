package com.taskmanagement.core.converter;

import com.taskmanagement.core.entity.TaskGroupEntity;
import com.taskmanagement.core.model.TaskGroupDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupConterver implements IConvertable<TaskGroupEntity, TaskGroupDTO >{

    @Override
    public TaskGroupEntity convertToEntity(TaskGroupDTO dto) {
        return copyConvertToEntity(dto, new TaskGroupEntity());
    }

    @Override
    public TaskGroupDTO convertToDto(TaskGroupEntity entity) {

        if(entity == null) {
            return null;
        }

        TaskGroupDTO dto = new TaskGroupDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getGroupName());

        return dto;
    }

    @Override
    public TaskGroupEntity copyConvertToEntity(TaskGroupDTO dto, TaskGroupEntity entity) {
        if(dto==null || entity == null) {
            return null;
        }

        entity.setGroupName(dto.getName());

        return entity;
    }

    @Override
    public List<TaskGroupDTO> convertToDtoList(List<TaskGroupEntity> entities) {
        return entities.parallelStream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskGroupEntity> convertToEntityList(List<TaskGroupDTO> dtoList) {
        return dtoList.parallelStream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
