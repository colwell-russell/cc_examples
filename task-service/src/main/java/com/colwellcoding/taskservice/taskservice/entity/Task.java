package com.colwellcoding.taskservice.taskservice.entity;

import java.sql.Timestamp;

public class Task {

    private Long id;
    private String taskType;
    private String status;
    private Timestamp createDate;
    private Timestamp lastUpdate;
}
