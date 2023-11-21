package com.AkmaDev.TaskManager.Controller;



import com.AkmaDev.TaskManager.Model.Personnel;
import com.AkmaDev.TaskManager.Service.PersonnelService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnels")
public class PersonnelController {
    @Autowired
    private final PersonnelService personnelService;

    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @GetMapping
    public ResponseEntity<List<Personnel>> getAllPersonnel() {
        return personnelService.getAllPersonnel();
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Personnel>> getPersonnelByUserName(@PathVariable("username") String username) {
        return personnelService.getPersonnelByUsername(username);
    }

    @PostMapping("/personnel")
    public ResponseEntity<Personnel> createPersonnel(@RequestBody Personnel personnel) {
        return personnelService.createPersonnel(personnel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonnel(@PathVariable("id") Long id) {
        return personnelService.deletePersonnel(id);
    }
}
