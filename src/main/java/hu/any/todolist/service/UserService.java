package hu.any.todolist.service;

import hu.any.todolist.dto.CreateToDoCommand;
import hu.any.todolist.dto.CreateUserCommand;
import hu.any.todolist.dto.ToDoDto;
import hu.any.todolist.dto.UserDto;
import hu.any.todolist.repository.ToDoRepository;
import hu.any.todolist.repository.UserNotFoundException;
import hu.any.todolist.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class UserService {

    private UsersRepository usersRepository;

    private ToDoRepository toDoRepository;

    private UserMapper userMapper;

    public UserDto createUser(CreateUserCommand command) {
        var user = userMapper.toEntity(command);
        usersRepository.save(user);
        return userMapper.toDto(user);
    }

    public ToDoDto createToDo(long userId, CreateToDoCommand createToDoCommand) {
        var toDo= userMapper.toEntity(createToDoCommand);
        var user= usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        toDo.setUser(user);
        toDoRepository.save(toDo);
        return userMapper.toDto(toDo);
    }
}
