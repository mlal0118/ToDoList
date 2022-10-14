package hu.any.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCommand {

    @Email(message = "Invalid email address")
    private String email;
}
