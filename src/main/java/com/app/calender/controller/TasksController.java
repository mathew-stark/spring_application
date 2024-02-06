package com.app.calender.controller;


import com.app.calender.model.Tasks;
import com.app.calender.repo.TaskList;
import com.app.calender.repo.TaskListRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Value("${user.name : hello}")
    private String name;

    @Value("${spring.profiles.active}")
    private String profile;


//    private final TaskList taskModel;
    private final TaskListRepo jdbcTasks;

    @Autowired
    TasksController(TaskListRepo jdbcTasks){
//        this.taskModel = taskModel;
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

    @GetMapping("/getTasksIdDate/{id1}/{date}")
    public List<Tasks> getTaskById(@PathVariable Integer id1, @PathVariable String date){
        return jdbcTasks.findByIdAndDate(id1, date);
    }

    @PostConstruct
    public void  init(){

        System.out.println(profile);

//        jdbcTasks.save(new Tasks(null,"sample database task", "sample date")) ;
    }

}
