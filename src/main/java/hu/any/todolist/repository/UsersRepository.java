package hu.any.todolist.repository;

import hu.any.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsersRepository extends JpaRepository<User, Long> {

}
