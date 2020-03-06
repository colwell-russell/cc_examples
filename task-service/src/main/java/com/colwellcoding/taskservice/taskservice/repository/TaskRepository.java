package com.colwellcoding.taskservice.taskservice.repository;

import com.colwellcoding.taskservice.taskservice.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
