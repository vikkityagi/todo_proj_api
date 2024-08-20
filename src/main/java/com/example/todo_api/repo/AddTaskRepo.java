package com.example.todo_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo_api.entity.AddTask;

@Repository
public interface AddTaskRepo extends JpaRepository<AddTask, Long> {
    
}
