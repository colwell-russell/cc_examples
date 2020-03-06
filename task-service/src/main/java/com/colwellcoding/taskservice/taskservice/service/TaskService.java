package com.colwellcoding.taskservice.taskservice.service;

import com.colwellcoding.taskservice.taskservice.entity.Task;
import com.colwellcoding.taskservice.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Optional findTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

}
