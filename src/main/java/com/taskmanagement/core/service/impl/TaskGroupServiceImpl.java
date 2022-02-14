package com.taskmanagement.core.service.impl;

import com.taskmanagement.core.converter.EmployeeConterver;
import com.taskmanagement.core.converter.TaskGroupConterver;
import com.taskmanagement.core.model.EmployeeDTO;
import com.taskmanagement.core.model.TaskGroupDTO;
import com.taskmanagement.core.repository.EmployeeRepository;
import com.taskmanagement.core.repository.TaskGroupRepository;
import com.taskmanagement.core.service.EmployeeService;
import com.taskmanagement.core.service.TaskGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskGroupServiceImpl implements TaskGroupService {

    @Autowired
    private TaskGroupConterver taskGroupConterver;

    @Autowired
    private TaskGroupRepository taskGroupRepository;

    @Override
    public TaskGroupDTO save(TaskGroupDTO taskGroupDTO){
        try{
            return taskGroupConterver.convertToDto(taskGroupRepository.save(taskGroupConterver.convertToEntity(taskGroupDTO)));
        }catch(Exception ex){
            //log the exception
            throw ex;
        }
    }

    @Override
    public List<TaskGroupDTO> list(){
        try{
            return taskGroupConterver.convertToDtoList(taskGroupRepository.findAll());
        }catch(Exception ex){
            //log the exception
            throw ex;
        }
    }
}
