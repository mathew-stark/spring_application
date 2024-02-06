package com.app.calender.model;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;


public record Tasks(
        @Id
        Integer id,
        String taskname,
        String date
) {}
