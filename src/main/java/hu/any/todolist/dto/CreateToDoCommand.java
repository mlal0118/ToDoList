package hu.any.todolist.dto;

import hu.any.todolist.entity.Importance;
import hu.any.todolist.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@AllArgsConstructor
public class CreateToDoCommand {

    @NotNull(message = "The description cannot be empty")
    private String description;

    @Future(message = "The deadline must be in the future.")
    private LocalDate deadline;

    private Importance importance;

    private final Status status=Status.NOT_STARTED;
}
