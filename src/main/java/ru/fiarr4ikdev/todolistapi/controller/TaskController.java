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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fiarr4ikdev.todolistapi.entity.Task;
import ru.fiarr4ikdev.todolistapi.service.TaskService;

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
            value = "/create")
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
            value = "/delete")
    @Operation(
            summary = "Удалить задачу",
            description = "Возвращает 200 если задача удалена"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Задача удалена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = Task.class
                            )
                    )
            ),
    })
    public ResponseEntity<HttpStatus> deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
