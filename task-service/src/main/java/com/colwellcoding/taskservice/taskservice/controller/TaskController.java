package com.colwellcoding.taskservice.taskservice.controller;

import com.colwellcoding.taskservice.taskservice.entity.Task;
import com.colwellcoding.taskservice.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public Optional findTaskById(@PathVariable("id")Long id){
        return taskService.findTaskById(id);
    }

    @PostMapping()
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping()
    public Task updateTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
}
