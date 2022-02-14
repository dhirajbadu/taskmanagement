package com.taskmanagement.core.entity;

import javax.persistence.Entity;

@Entity(name = "task_group")
public class TaskGroupEntity extends AbstractEntity<Long>{
    private String groupName;

    public TaskGroupEntity(){}

    public TaskGroupEntity(String groupName){
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
