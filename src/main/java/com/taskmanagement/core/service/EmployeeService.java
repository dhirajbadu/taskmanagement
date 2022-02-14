package com.taskmanagement.core.service;

import com.taskmanagement.core.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    public EmployeeDTO save(EmployeeDTO employeeDTO);

    public List<EmployeeDTO> list();
}
