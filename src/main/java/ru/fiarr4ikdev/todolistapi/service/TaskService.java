package ru.fiarr4ikdev.todolistapi.service;

import org.springframework.stereotype.Service;
import ru.fiarr4ikdev.todolistapi.entity.Task;
import ru.fiarr4ikdev.todolistapi.repo.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

}
