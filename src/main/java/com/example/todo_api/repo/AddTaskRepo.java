package com.example.todo_api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todo_api.entity.AddTask;

@Repository
public interface AddTaskRepo extends JpaRepository<AddTask, Long> {

    @Query(value="SELECT *from tasks ORDER BY date DESC",nativeQuery = true)
    List<AddTask> findAllDataByDate();
    
}
