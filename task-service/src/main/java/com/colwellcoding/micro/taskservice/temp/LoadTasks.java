package com.colwellcoding.micro.taskservice.temp;

import com.colwellcoding.micro.taskservice.entity.Task;
import com.colwellcoding.micro.taskservice.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadTasks {

    @Bean
    CommandLineRunner initDB(TaskRepository taskRepository) {
        return args -> {
            log.info("Loading task1: " + taskRepository.save(new Task("TEST", "NEW")));
        };
    }
}
