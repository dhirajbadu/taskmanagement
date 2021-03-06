package com.taskmanagement.core.entity;

import javax.persistence.Entity;

@Entity(name = "employee")
public class EmployeeEntity extends AbstractEntity<Long>{

    private String name;

    public EmployeeEntity(){}

    public EmployeeEntity(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
