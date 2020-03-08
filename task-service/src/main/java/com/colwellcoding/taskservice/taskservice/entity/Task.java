package com.colwellcoding.taskservice.taskservice.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String taskType;
    private String status;

    @CreationTimestamp
    private Timestamp createDate;

    @UpdateTimestamp
    private Timestamp lastUpdate;
}
