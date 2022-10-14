package hu.any.todolist.controller;

import hu.any.todolist.dto.*;
import hu.any.todolist.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/users")
    @Operation(summary = "Create a new user", description = "Create a new user with email address")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserCommand command,
                                              UriComponentsBuilder uri) {
        var user = userService.createUser(command);
        return ResponseEntity
                .created(uri.path("/api/users/{id}")
                .buildAndExpand(user.getId()).toUri())
                .body(user);
    }

    @PostMapping("/users/{id}/todos")
    @Operation(summary = "Create a new todo", description = "Create a new todo with user id")
    public ResponseEntity<ToDoDto> createToDo(@PathVariable("id") long userId,
                                              @Valid @RequestBody CreateToDoCommand command,
                                              UriComponentsBuilder uri) {
        var toDo=userService.createToDo(userId,command);
        return ResponseEntity
                .created(uri.path("api/users/{id}/todos")
                .buildAndExpand(userId, toDo.getDescription()).toUri())
                .body(toDo);
    }
}
