package com.AkmaDev.TaskManager.Service;

import com.AkmaDev.TaskManager.Model.Personnel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonnelService {

        ResponseEntity<List<Personnel>> getAllPersonnel();

        ResponseEntity<Personnel> getPersonnelById(Long id);

        ResponseEntity<List<Personnel>> getPersonnelByUsername(String username);

        ResponseEntity<Personnel> createPersonnel(Personnel personnel);

        ResponseEntity<Personnel> updatePersonnel(Personnel user, Long id);

        ResponseEntity<Void> deletePersonnel(Long id);

}
