package ru.fiarr4ikdev.todolistapi.service;

import org.springframework.stereotype.Service;
import ru.fiarr4ikdev.todolistapi.entity.Task;
import ru.fiarr4ikdev.todolistapi.repo.TaskRepository;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        } else {
            throw new RuntimeException("Задача не найдена с id " + id);
        }
    }

}
