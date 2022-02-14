package com.taskmanagement.core.converter;

import com.taskmanagement.core.entity.EmployeeEntity;
import com.taskmanagement.core.model.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeConverter implements IConvertable<EmployeeEntity, EmployeeDTO >{

    @Override
    public EmployeeEntity convertToEntity(EmployeeDTO dto) {
        return copyConvertToEntity(dto, new EmployeeEntity());
    }

    @Override
    public EmployeeDTO convertToDto(EmployeeEntity entity) {

        if(entity == null) {
            return null;
        }

        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    @Override
    public EmployeeEntity copyConvertToEntity(EmployeeDTO dto, EmployeeEntity entity) {
        if(dto==null || entity == null) {
            return null;
        }

        entity.setName(dto.getName());

        return entity;
    }

    @Override
    public List<EmployeeDTO> convertToDtoList(List<EmployeeEntity> entities) {
        return entities.parallelStream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeEntity> convertToEntityList(List<EmployeeDTO> dtoList) {
        return dtoList.parallelStream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
