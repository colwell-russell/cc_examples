package com.colwellcoding.micro.taskservice.controller;

import com.colwellcoding.micro.taskservice.entity.Task;
import com.colwellcoding.micro.taskservice.exception.TaskNotFoundException;
import com.colwellcoding.micro.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("v1/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/id/{id}")
    public EntityModel<Task> findTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

        return new EntityModel<Task>(task,
                linkTo(methodOn(TaskController.class).findTask(id)).withSelfRel(),
                linkTo(methodOn(TaskController.class).updateTask(task)).withRel("update"));
    }

    @PostMapping
    public EntityModel<Task> createTask(@RequestBody Task newTask) {
        Task task = taskRepository.save(newTask);

        return new EntityModel<Task>(task,
                linkTo(methodOn(TaskController.class).findTask(task.getId())).withSelfRel(),
                linkTo(methodOn(TaskController.class).updateTask(task)).withRel("update"));
    }

    @PutMapping
    public EntityModel<Task> updateTask(@RequestBody Task updateTask) {
        Task task = taskRepository.findById(updateTask.getId()).orElseThrow(() -> new TaskNotFoundException(updateTask.getId()));
        task.setStatus(updateTask.getStatus());

        task = taskRepository.save(task);

        return new EntityModel<Task>(task,
                linkTo(methodOn(TaskController.class).findTask(task.getId())).withSelfRel(),
                linkTo(methodOn(TaskController.class).updateTask(task)).withRel("update"));
    }
}
