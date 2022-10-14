package hu.any.todolist.dto;


import hu.any.todolist.entity.Importance;
import hu.any.todolist.entity.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ToDoDto {

    private String description;

    private LocalDate deadline;

    private Importance importance;

    private Status status;
}
