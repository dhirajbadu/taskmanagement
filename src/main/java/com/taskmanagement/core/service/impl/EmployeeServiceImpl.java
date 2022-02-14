package com.taskmanagement.core.service.impl;

import com.taskmanagement.core.converter.EmployeeConterver;
import com.taskmanagement.core.model.EmployeeDTO;
import com.taskmanagement.core.repository.EmployeeRepository;
import com.taskmanagement.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeConterver employeeConterver;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO){
        try{
            return employeeConterver.convertToDto(employeeRepository.save(employeeConterver.convertToEntity(employeeDTO)));
        }catch(Exception ex){
            //log the exception
            throw ex;
        }
    }

    @Override
    public List<EmployeeDTO> list(){
        try{
            return employeeConterver.convertToDtoList(employeeRepository.findAll());
        }catch(Exception ex){
            //log the exception
            throw ex;
        }
    }
}
