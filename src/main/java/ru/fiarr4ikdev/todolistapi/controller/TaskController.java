package ru.fiarr4ikdev.todolistapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fiarr4ikdev.todolistapi.entity.Task;
import ru.fiarr4ikdev.todolistapi.service.TaskService;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/v1/task")
@Tag(
        name = "Контроллер для работы с задачами"
)
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PutMapping(
            value = "/create"
    )
    @Operation(
            summary = "Создать задачу",
            description = "Возвращает 200 если задача создана"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Задача создана",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = Task.class
                            )
                    )
            ),
    })
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    @Operation(
            summary = "Удалить задачу по id",
            description = "Возвращает 200 если задача удалена"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Задача удалена"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "id задачи не найден"
            )
    })
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        try {
            taskService.deleteTaskById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    @Operation(
            summary = "Показать все задачи",
            description = "Возвращает 200 если отображены все задачи"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Задачи отображены",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = Task.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "id задачи не найден"
            )
    })
    public ResponseEntity<List<Task>> allTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/get/{id}")
    @Operation(
            summary = "Показать задачу по id",
            description = "Возвращает 200 если задача найдена"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Задача отображена"
            )
    })
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        try {
            taskService.getTaskById(id);
            return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
