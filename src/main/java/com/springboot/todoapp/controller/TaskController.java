package com.springboot.todoapp.controller;

import com.springboot.todoapp.entity.Task;
import com.springboot.todoapp.mapper.TaskMapper;
import com.springboot.todoapp.repository.TaskRepository;
import com.springboot.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/todo/task")
@CrossOrigin("http://localhost:8081/")
public class TaskController {


    @Autowired
    private TaskService taskService;
    @GetMapping
    public List<Task> findAll(@RequestParam Integer id, @RequestHeader HttpHeaders headers){
         System.out.println(headers.get("Authorization"));
        return taskService.getAllTasks(id,true); //+token);
    }

    @PostMapping
    public TaskMapper addTask(@RequestBody TaskMapper task){

        try {
            taskService.addTask(task);
            return task;
        }
        catch (Exception e){
            System.out.println("Something went wrong!");
            throw e;
        }
    }

    @DeleteMapping
    public void deleteTask(@RequestParam Long id){

        try {
            taskService.deleteTask(id);

        }
        catch (Exception e){
            throw e;
        }
    }

    @PutMapping
    public void updateTask(@RequestBody TaskMapper taskMapper){

        try {
            taskService.updateTask(taskMapper);

        }
        catch (Exception e){
            throw e;
        }
    }

    @GetMapping("priority")
    public List<Task> filterPriority(@RequestParam Integer id, @RequestParam Integer priority){
        return taskService.filterPriority(id, true, priority);
    }

    @GetMapping("group")
    public List<Task> filterGroup(@RequestParam Integer id, @RequestParam Integer group){
       return taskService.filterGroup(id, true, group);
    }

    @GetMapping("date")
    public List<Task> filterDate(@RequestParam Integer id, @RequestParam("dueDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        return taskService.filterDate(id, true, date);
    }

}
