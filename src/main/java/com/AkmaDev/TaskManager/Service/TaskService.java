package com.AkmaDev.TaskManager.Service;

import com.AkmaDev.TaskManager.Model.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    ResponseEntity<List<Task>> getAllTasks();

    ResponseEntity<Task> getTaskById(Long id);

    ResponseEntity<List<Task>> getTaskByName(String taskName);

    ResponseEntity<Task> createTask(Task task);

    ResponseEntity<Task> updateTask(Task t, Long id);

    ResponseEntity<Void> deleteTask(Long id);
}
