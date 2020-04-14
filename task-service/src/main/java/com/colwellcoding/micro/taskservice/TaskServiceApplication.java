package com.colwellcoding.micro.taskservice;

import com.colwellcoding.micro.taskservice.entity.Task;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@SpringBootApplication
@Slf4j
public class TaskServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskServiceApplication.class, args);
		log.info("******: Starting Mongo operations");
		MongoOperations mongoOps = new MongoTemplate(MongoClients.create("mongodb://mongo:27017"), "database");
		log.info("******: Created client");
		Task task = new Task();
		task.setType("TEST");
		task.setStatus("OPEN");
		log.info("******: Inserting task");
		mongoOps.insert(task);
		log.info("******: Finding task");

		Task result = mongoOps.findOne(new Query(where("type").is("TEST")), Task.class);
		log.info("******: " + result.toString());
	}

}
