package com.colwellcoding.taskservice.taskservice.controller;

import com.colwellcoding.taskservice.taskservice.entity.Task;
import com.colwellcoding.taskservice.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public String hello(){
        return "Hello";
    }

    @GetMapping("/find/{id}")
    public Task findTaskById(@PathVariable("id")Long id){
        return (Task)taskService.findTaskById(id).get();
    }

    @PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping(path = "/members", consumes = "application/json", produces = "application/json")
    public Task updateTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
}
