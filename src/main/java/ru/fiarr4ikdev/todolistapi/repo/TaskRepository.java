package ru.fiarr4ikdev.todolistapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiarr4ikdev.todolistapi.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
