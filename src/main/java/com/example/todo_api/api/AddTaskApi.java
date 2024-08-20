package com.example.todo_api.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.resources.AddTaskResources;

@RestController
@CrossOrigin
public interface AddTaskApi {

    @PostMapping("/add_task")
    public ResponseEntity<List<AddTaskResources>> create(@RequestBody List<AddTaskResources> addTaskResources);
    
}
