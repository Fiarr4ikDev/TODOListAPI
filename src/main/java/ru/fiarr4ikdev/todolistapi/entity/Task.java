package ru.fiarr4ikdev.todolistapi.entity;

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
public class Task {

    @Id @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "task_id"
    )
    private int id;

    @Column(
            name = "task_title"
    )
    private String title;

    @Column(
            name = "task_description"
    )
    private String description;

    @Column(
            name = "task_priority"
    )
    private int priority;

}
