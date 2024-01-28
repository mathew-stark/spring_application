package com.app.calender.controller;


import com.app.calender.model.Tasks;
import com.app.calender.repo.TaskList;
import com.app.calender.repo.TaskListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TasksController {


    private final TaskList taskModel;
    private final TaskListRepo jdbcTasks;

    @Autowired
    TasksController(TaskList taskModel,TaskListRepo jdbcTasks){
        this.taskModel = taskModel;
        this.jdbcTasks = jdbcTasks;
    }

    @GetMapping("/getTasks")
    public List<Tasks> getTasks(){

//        return taskModel.getTasks();
        return jdbcTasks.findAll();
    }

    @PostMapping("/addTasks")
    public void addTasks(@RequestBody Tasks tasks){
//        taskModel.addTask(tasks);
        jdbcTasks.save(tasks);
    }
    @GetMapping("/getTasksBetween/{id1}/{id2}")
    public List<Tasks> getTaskById(@PathVariable Integer id1, @PathVariable Integer id2){
        return jdbcTasks.findAllByIdBetween(id1,id2);
    }
}
