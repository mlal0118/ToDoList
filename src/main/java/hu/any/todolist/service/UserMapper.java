package hu.any.todolist.service;

import hu.any.todolist.dto.CreateToDoCommand;
import hu.any.todolist.dto.CreateUserCommand;
import hu.any.todolist.dto.ToDoDto;
import hu.any.todolist.dto.UserDto;
import hu.any.todolist.entity.ToDo;
import hu.any.todolist.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(CreateUserCommand command);
    ToDo toEntity(CreateToDoCommand command);
    UserDto toDto(User user);
    ToDoDto toDto(ToDo toDo);
}
