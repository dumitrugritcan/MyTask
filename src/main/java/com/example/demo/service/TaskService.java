package com.example.demo.service;

import com.example.demo.entity.Task;

public interface TaskService {
    Task createTask(String title, boolean isCompleted);

    Task updateTask(Long id, String title, boolean completed);

    Task getTaskById(Long id);

    void deleteTaskById(Long id);
}
