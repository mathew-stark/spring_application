package com.app.calender.repo;

import com.app.calender.model.Tasks;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class TaskList {

    private List<Tasks> list;

    TaskList(){
        list = new ArrayList<>();
    }
    public List<Tasks> getTasks(){
        return list;
    }

    public void addTask(Tasks task){
        if (list.stream().anyMatch(t -> Objects.equals(t.id(), task.id()))){
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "the task id is already present");
        }
        list.add(task);
    }

    @PostConstruct
    public void init(){
        list.add(new Tasks(1, "sample task", "sample date"));
    }

}
