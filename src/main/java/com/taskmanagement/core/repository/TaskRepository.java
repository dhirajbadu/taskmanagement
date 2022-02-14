package com.taskmanagement.core.repository;

import com.taskmanagement.core.entity.EmployeeEntity;
import com.taskmanagement.core.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
