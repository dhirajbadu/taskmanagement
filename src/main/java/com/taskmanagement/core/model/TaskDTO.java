package com.taskmanagement.core.model;

import com.taskmanagement.core.enumconstant.TaskStatus;

public class TaskDTO {

    private Long id;

    private String name;

    private String description;

    private TaskGroupDTO taskGroup;

    private EmployeeDTO assignee;

    private TaskStatus status;

    private int timeSpend;

    private TaskDTO subTask;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskGroupDTO getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(TaskGroupDTO taskGroup) {
        this.taskGroup = taskGroup;
    }

    public EmployeeDTO getAssignee() {
        return assignee;
    }

    public void setAssignee(EmployeeDTO assignee) {
        this.assignee = assignee;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public int getTimeSpend() {
        return timeSpend;
    }

    public void setTimeSpend(int timeSpend) {
        this.timeSpend = timeSpend;
    }

    public TaskDTO getSubTask() {
        return subTask;
    }

    public void setSubTask(TaskDTO subTask) {
        this.subTask = subTask;
    }
}
