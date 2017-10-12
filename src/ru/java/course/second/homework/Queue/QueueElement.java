package ru.java.course.second.homework.Queue;

import java.time.LocalDateTime;

public class QueueElement {
    private String value;
    private LocalDateTime created;

    public QueueElement(String value, LocalDateTime created) {
        this.value = value;
        this.created = created;
    }

    public String getValue() {
        return value;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
