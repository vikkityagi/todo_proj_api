package com.example.todo_api.service;

import java.util.List;

import com.example.todo_api.resources.AddTaskResources;

public interface AddTaskService {

    List<AddTaskResources> createService(List<AddTaskResources> addTaskResources) throws Exception;

    List<AddTaskResources> listService() throws Exception;
    
}
