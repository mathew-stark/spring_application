package com.app.calender.repo;

import com.app.calender.model.Tasks;
import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

public interface TaskListRepo extends ListCrudRepository<Tasks, Integer> {
    List<Tasks> findAllByIdBetween(Integer x, Integer y);
    List<Tasks> findByIdAndDate(Integer x, String date);
}
