package hu.any.todolist;

import hu.any.todolist.dto.CreateUserCommand;
import hu.any.todolist.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerWebClientIT {
    @Autowired
    WebTestClient webClient;

    @Test
    void testCreateUser(){
        var result = webClient
                .post()
                .uri( "/api/users")
                .bodyValue(new CreateUserCommand("johndoe@gmail.com"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(UserDto.class).value(e -> assertEquals("johndoe@gmail.com", e.getEmail()))
                .returnResult()
                .getResponseBody();
    }

    @Test
    void testInvalidUser(){
        webClient
                .post()
                .uri("/api/users")
                .bodyValue(new CreateUserCommand("janedoe|gmail.com"))
                .exchange()
                .expectStatus()
                .isBadRequest();
    }
}
