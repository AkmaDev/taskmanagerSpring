package com.AkmaDev.TaskManager.Service;

import com.AkmaDev.TaskManager.Model.Task;
import com.AkmaDev.TaskManager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private final TaskRepository taskRepository;


    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(tasks);
        }
    }

    @Override
    public ResponseEntity<Task> getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task foundTask = optionalTask.get();
            return ResponseEntity.ok(foundTask);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public ResponseEntity<List<Task>> getTaskByName(String taskName) {
        List<Task> tasks = taskRepository.findByTitle(taskName);

        if (tasks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tasks);
    }

    @Override
    public ResponseEntity<Task> createTask(Task task) {
        Task createdTask = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @Override
    public ResponseEntity<Task> updateTask(Task t, Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task taskToUpdate =  optionalTask.get();

            if (t.getId() != null) {
                taskToUpdate.setId(t.getId());
            }
            if (t.getDescription() != null) {
                taskToUpdate.setDescription(t.getDescription());
            }
            if (t.getTitle() != null) {
                taskToUpdate.setTitle(t.getTitle());
            }
            if(t.getDueDate() != null) {
                taskToUpdate.setDueDate(t.getDueDate());
            }

            Task updatedTask = taskRepository.save(taskToUpdate);
            return ResponseEntity.ok(updatedTask);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<Void> deleteTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task taskToDelete = optionalTask.get();
            taskRepository.delete(taskToDelete);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


}
