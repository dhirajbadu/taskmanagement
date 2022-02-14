package com.taskmanagement.core.service;

import com.taskmanagement.core.model.EmployeeDTO;
import com.taskmanagement.core.model.TaskGroupDTO;

import java.util.List;

public interface TaskGroupService {

    public TaskGroupDTO save(TaskGroupDTO taskGroupDTO);

    public List<TaskGroupDTO> list();
}
