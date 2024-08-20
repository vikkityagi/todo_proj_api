package com.example.todo_api.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.todo_api.enums.TaskEnum;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tasks")
public class AddTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="task_id")
    private int taskId;

    @Column(name="progress")
    private int progress;

    @Column(name="date")
    private LocalDate date;

    @Column(name="time_start")
    private LocalTime timeStart;

    @Column(name="end_time")
    private LocalTime endTime;

    @Column(name="total_time")
    private String totalTime;
    
}
