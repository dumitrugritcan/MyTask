package com.example.demo.service.impl;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private Task mapTask(String title, boolean isCompleted){
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(isCompleted);
        task.setCreationDate(LocalDate.now());
        return task;
    }

    @Override
    public Task createTask(String title, boolean isCompleted) {
        Task task = mapTask(title,isCompleted);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, String title, boolean isCompleted) {
        Task task = mapTask(title,isCompleted);
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
