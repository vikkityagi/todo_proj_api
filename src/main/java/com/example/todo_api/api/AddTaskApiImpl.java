package com.example.todo_api.api;

import java.util.List;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.todo_api.resources.AddTaskResources;
import com.example.todo_api.service.AddTaskService;

public class AddTaskApiImpl implements AddTaskApi {

    @Autowired
    private AddTaskService addTaskService;

    @Override
    public ResponseEntity<List<AddTaskResources>> create(List<AddTaskResources> addTaskResources) {
        // TODO Auto-generated method stub
        try{
            List<AddTaskResources> addTaskResources2 = this.addTaskService.createService(addTaskResources);
            if(addTaskResources2 != null){
                return new ResponseEntity<>(addTaskResources2,HttpStatus.OK);
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
