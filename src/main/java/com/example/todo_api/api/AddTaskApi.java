package com.example.todo_api.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo_api.resources.AddTaskResources;


@CrossOrigin
@RequestMapping("/api/v1")
public interface AddTaskApi {

    @PostMapping(value = "/add_task")
    public ResponseEntity<List<AddTaskResources>> create(@RequestBody List<AddTaskResources> addTaskResources);

    @GetMapping(value = "/add_tasks")
    public ResponseEntity<List<AddTaskResources>> list();
    
}
