package com.AkmaDev.TaskManager.Config;


import com.AkmaDev.TaskManager.Model.Task;
import com.AkmaDev.TaskManager.Repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer {

    @Autowired
    private final TaskRepository taskRepository;

    public DataInitializer(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostConstruct
    public void init() {
        // Tâche 1
        Task task1 = new Task("Acheter des courses", "Acheter des produits alimentaires pour la semaine", LocalDateTime.of(2023, 11, 5, 10, 0));
        taskRepository.save(task1);

        // Tâche 2
        Task task2 = new Task("Réunion avec l'équipe", "Réunion hebdomadaire de l'équipe de projet", LocalDateTime.of(2023, 11, 7, 14, 30));
        taskRepository.save(task2);

        // Tâche 3
        Task task3 = new Task("Préparer une présentation", "Préparer une présentation pour le client", LocalDateTime.of(2023, 11, 10, 16, 0));
        taskRepository.save(task3);

        // Tâche 4
        Task task4 = new Task("Faire de l'exercice", "Faire de l'exercice pendant 30 minutes", LocalDateTime.of(2023, 11, 6, 18, 0));
        taskRepository.save(task4);

        // Tâche 5
        Task task5 = new Task("Lire un livre", "Lire le dernier roman pendant la pause déjeuner", LocalDateTime.of(2023, 11, 8, 12, 30));
        taskRepository.save(task5);
    }

}
