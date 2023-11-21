package com.AkmaDev.TaskManager.Controller;


import com.AkmaDev.TaskManager.Model.Task;
import com.AkmaDev.TaskManager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks()  {
            return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task>  getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<Task>> getTaskByName(@PathVariable("username") String task) {
        return taskService.getTaskByName(task);
    }

    @PostMapping("/task")
    public Task createTask( @RequestBody Task task) {
       return taskService.createTask(task).getBody();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task t) {
        return taskService.updateTask(t, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long id) {
        return taskService.deleteTask(id);
    }

}
