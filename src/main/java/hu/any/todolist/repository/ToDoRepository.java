package hu.any.todolist.repository;

import hu.any.todolist.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ToDoRepository  extends JpaRepository<ToDo, Long> {

}
