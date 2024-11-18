package ru.fiarr4ikdev.todolistapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(
        name = "tasks"
)
@Schema(
        description = "Сущность задача"
)
public class Task {

    @Id @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "task_id"
    )
    @Schema(
            description = "Id задачи с генерацией IDENTITY"
    )
    private int id;

    @Column(
            name = "task_title"
    )
    @Schema(
            description = "Заголовок задачи",
            example = "Написать REST API"
    )
    private String title;

    @Column(
            name = "task_description"
    )
    @Schema(
            description = "Описание задачи",
            example = "(Подробнее о создании REST API)"
    )
    private String description;

    @Column(
            name = "task_priority"
    )
    @Schema(
            description = "Приоритет задачи",
            example = "0 - Самый высокий"
    )
    private int priority;

}
