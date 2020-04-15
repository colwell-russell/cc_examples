package com.colwellcoding.micro.taskservice.repository;

import com.colwellcoding.micro.taskservice.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
