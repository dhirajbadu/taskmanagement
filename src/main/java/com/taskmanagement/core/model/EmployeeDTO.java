package com.taskmanagement.core.model;

import com.taskmanagement.core.entity.EmployeeEntity;
import com.taskmanagement.core.entity.TaskEntity;
import com.taskmanagement.core.entity.TaskGroupEntity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class EmployeeDTO {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
