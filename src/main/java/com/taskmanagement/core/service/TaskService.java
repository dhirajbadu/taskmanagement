package com.taskmanagement.core.service;

import com.taskmanagement.core.model.EmployeeDTO;
import com.taskmanagement.core.model.TaskDTO;

import java.util.List;

public interface TaskService {

    public TaskDTO getById(Long taskId);

    public TaskDTO save(TaskDTO taskDTO);

    public List<TaskDTO> list();

    public void delete(Long taskId);

    public TaskDTO update(TaskDTO taskDTO);
}
