package hu.any.todolist.controller;

import hu.any.todolist.repository.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import java.net.URI;
import java.util.UUID;

@ControllerAdvice
public class UserExceptionHandler  implements ProblemHandling {
    @ExceptionHandler
    ResponseEntity<Problem> handleException(UserNotFoundException exception, NativeWebRequest request) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("users/users-not-found"))
                        .withTitle("Not found")
                        .withStatus(Status.NOT_FOUND)
                        .withDetail(exception.getMessage())
                        .with("exceptionId", UUID.randomUUID().toString())
                        .build();
        return this.create(exception, problem, request);
    }
}
