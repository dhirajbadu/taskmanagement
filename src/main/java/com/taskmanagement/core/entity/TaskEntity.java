package com.taskmanagement.core.entity;

import com.taskmanagement.core.enumconstant.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity(name = "task")
public class TaskEntity extends AbstractEntity<Long>{

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private TaskGroupEntity taskGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    private EmployeeEntity assignee;

    private TaskStatus status;

    private int timeSpend;//in hours

    @ManyToOne(fetch = FetchType.EAGER)
    private TaskEntity subTask;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskGroupEntity getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(TaskGroupEntity taskGroup) {
        this.taskGroup = taskGroup;
    }

    public EmployeeEntity getAssignee() {
        return assignee;
    }

    public void setAssignee(EmployeeEntity assignee) {
        this.assignee = assignee;
    }

    public int getTimeSpend() {
        return timeSpend;
    }

    public void setTimeSpend(int timeSpend) {
        this.timeSpend = timeSpend;
    }

    public TaskEntity getSubTask() {
        return subTask;
    }

    public void setSubTask(TaskEntity subTask) {
        this.subTask = subTask;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
