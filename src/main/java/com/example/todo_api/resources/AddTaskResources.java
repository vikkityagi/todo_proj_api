package com.example.todo_api.resources;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddTaskResources {

    @JsonProperty("id")
    private long id;

    @JsonProperty("task_name")
    private int task_name;

    @JsonProperty("progress")
    private int progress;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("start_time")
    private LocalTime start_time;

    @JsonProperty("end_time")
    private LocalTime end_time;
    
}
