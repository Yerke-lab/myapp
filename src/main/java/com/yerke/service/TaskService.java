package com.yerke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.yerke.entity.Task;
import com.yerke.entity.TaskStatus;
import com.yerke.repository.TaskRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(@NonNull Long id) {
        return taskRepository.findById(id);
    }

    public Task addTask(Task task) {
        task.setCreatedAt(new Date(System.currentTimeMillis())); // устанавливаем текущую дату
        return taskRepository.save(task);
    }

    public Task createNewInProgressTask() {
        Task task = new Task();
        task.setStatus(TaskStatus.IN_PROGRESS);
        // Другие действия по созданию задачи, если нужно
        return taskRepository.save(task); // предположим, что здесь сохранение задачи в репозитории
    }

    public void updateTaskStatus(@NonNull Long id, TaskStatus status) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        optionalTask.ifPresent(task -> {
            task.setStatus(status);
            taskRepository.save(task);
        });
    }

    public void deleteTask(@NonNull Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }
}
