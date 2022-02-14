package com.taskmanagement.core.service.impl;

import com.taskmanagement.core.converter.TaskGroupConverter;
import com.taskmanagement.core.model.TaskGroupDTO;
import com.taskmanagement.core.repository.TaskGroupRepository;
import com.taskmanagement.core.service.TaskGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskGroupServiceImpl implements TaskGroupService {

    @Autowired
    private TaskGroupConverter taskGroupConverter;

    @Autowired
    private TaskGroupRepository taskGroupRepository;

    @Override
    public TaskGroupDTO save(TaskGroupDTO taskGroupDTO){
        try{
            return taskGroupConverter.convertToDto(taskGroupRepository.save(taskGroupConverter.convertToEntity(taskGroupDTO)));
        }catch(Exception ex){
            //log the exception
            throw ex;
        }
    }

    @Override
    public List<TaskGroupDTO> list(){
        try{
            return taskGroupConverter.convertToDtoList(taskGroupRepository.findAll());
        }catch(Exception ex){
            //log the exception
            throw ex;
        }
    }
}
