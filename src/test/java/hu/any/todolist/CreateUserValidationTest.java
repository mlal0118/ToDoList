package hu.any.todolist;


import hu.any.todolist.dto.CreateUserCommand;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class CreateUserValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = (Validator) factory.getValidator();
    }

    @Test
    public void testWrongEmail() {
        CreateUserCommand userCommand = new CreateUserCommand();
        userCommand.setEmail("johndoe.com");
        Set<ConstraintViolation<CreateUserCommand>> violations = validator.validate(userCommand);
        assertEquals(false, violations.isEmpty());
    }

    @Test
    public void testCorrectEmail() {
        CreateUserCommand userCommand = new CreateUserCommand();
        userCommand.setEmail("johndoe@gmail.com");
        Set<ConstraintViolation<CreateUserCommand>> violations = validator.validate(userCommand);
        assertEquals(true, violations.isEmpty());
    }




}
