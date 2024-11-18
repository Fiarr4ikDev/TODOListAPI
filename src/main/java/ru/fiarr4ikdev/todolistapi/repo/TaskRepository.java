package ru.fiarr4ikdev.todolistapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiarr4ikdev.todolistapi.entity.Task;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findTaskById(int id);

}
