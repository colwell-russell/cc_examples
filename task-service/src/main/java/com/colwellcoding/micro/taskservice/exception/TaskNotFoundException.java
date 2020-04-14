package com.colwellcoding.micro.taskservice.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String id) {
        super("Could not find task " + id);
    }
}
