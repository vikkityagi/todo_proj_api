package com.example.todo_api.serviceimpl;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.todo_api.entity.AddTask;
import com.example.todo_api.enums.ProgressEnum;
import com.example.todo_api.enums.TaskEnum;
import com.example.todo_api.repo.AddTaskRepo;
import com.example.todo_api.resources.AddTaskResources;
import com.example.todo_api.service.AddTaskService;

@Service
public class AddTaskServiceImpl implements AddTaskService {

    @Autowired
    private AddTaskRepo addTaskRepo;

    @Override
    public List<AddTaskResources> createService(List<AddTaskResources> addTaskResources) throws Exception {

        // TODO Auto-generated method stub
        for (AddTaskResources addTaskResources2 : addTaskResources) {
            AddTask addTask = new AddTask();
            if (addTaskResources2.getProgress() == 2) {
                addTask.setTaskId(addTaskResources2.getTask_id());
                addTask.setProgress(addTaskResources2.getProgress());
                addTask.setDate(addTaskResources2.getDate());
            } else {
                addTask.setTaskId(addTaskResources2.getTask_id());
                addTask.setProgress(addTaskResources2.getProgress());
                addTask.setDate(addTaskResources2.getDate());
                addTask.setTimeStart(addTaskResources2.getStart_time());
                addTask.setEndTime(addTaskResources2.getEnd_time());

                // Parse time strings into LocalTime objects
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime time1 = LocalTime.parse(addTaskResources2.getStart_time() + "", formatter);
                LocalTime time2 = LocalTime.parse(addTaskResources2.getEnd_time() + "", formatter);

                // Calculate the difference
                Duration duration = Duration.between(time1, time2);

                // Get the difference in minutes
                long minutes = duration.toMinutes();

                // Convert minutes to hours and minutes
                long hours = minutes / 60;
                long remainingMinutes = minutes % 60;

                // Format hours to ensure it's always two digits
                String formattedHours = String.format("%02d", hours);

                // Format remaining minutes to ensure it's always two digits
                String formattedMinutes = String.format("%02d", remainingMinutes);

                addTask.setTotalTime(formattedHours + ":" + formattedMinutes);
            }

            this.addTaskRepo.save(addTask);

        }
        return addTaskResources;
    }

    @Override
    public List<AddTaskResources> listService() throws Exception {
        // TODO Auto-generated method stub
        List<AddTaskResources> addTaskResources = new ArrayList<>();
        for (AddTask addTask : this.addTaskRepo.findAllDataByDate()) {
            AddTaskResources addTaskResourcesObj = new AddTaskResources();
            addTaskResourcesObj.setId(addTask.getId());
            addTaskResourcesObj.setTaskName(TaskEnum.fromValue(addTask.getTaskId()) + "");
            addTaskResourcesObj.setProgressName(ProgressEnum.fromValue(addTask.getProgress()) + "");
            addTaskResourcesObj.setStart_time(addTask.getTimeStart());
            addTaskResourcesObj.setEnd_time(addTask.getEndTime());
            addTaskResourcesObj.setDate(addTask.getDate());
            addTaskResourcesObj.setTotalTime(addTask.getTotalTime());

            addTaskResources.add(addTaskResourcesObj);
        }

        return addTaskResources;

    }

}
