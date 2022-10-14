package hu.any.todolist.dto;

import hu.any.todolist.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String email;

    private List<ToDo> toDoList;
}
