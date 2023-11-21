package com.AkmaDev.TaskManager.Service;

import com.AkmaDev.TaskManager.Model.Personnel;
import com.AkmaDev.TaskManager.Repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelServiceImpl implements PersonnelService{

        @Autowired
        private final PersonnelRepository personnelRepository;

        public PersonnelServiceImpl(PersonnelRepository personnelRepository) {
            this.personnelRepository = personnelRepository;
        }

        @Override
        public ResponseEntity<List<Personnel>> getAllPersonnel() {
            List<Personnel> users = personnelRepository.findAll();
            if (users.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(users);
            }
        }

        @Override
        public ResponseEntity<Personnel> getPersonnelById(Long id) {
            Optional<Personnel> optionalPersonnel = personnelRepository.findById(id);

            if (optionalPersonnel.isPresent()) {
                Personnel foundPersonnel = optionalPersonnel.get();
                return ResponseEntity.ok(foundPersonnel);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

       @Override
        public ResponseEntity<List<Personnel>> getPersonnelByUsername(String username) {
            List<Personnel> personnels = personnelRepository.findByPersonnelName(username);

            if (personnels.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(personnels);
        }

        @Override
        public ResponseEntity<Personnel> createPersonnel(Personnel personnel) {
            Personnel createdPersonnel = personnelRepository.save(personnel);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPersonnel);
        }

        @Override
        public ResponseEntity<Personnel> updatePersonnel(Personnel personnel, Long id) {
            Optional<Personnel> optionalPersonnel = personnelRepository.findById(id);

            if (optionalPersonnel.isPresent()) {
                Personnel personnelToUpdate = optionalPersonnel.get();

                if (personnel.getPersonnelName() != null) {
                    personnelToUpdate.setPersonnelName(personnel.getPersonnelName());
                }
                if (personnel.getEmail() != null) {
                    personnelToUpdate.setEmail(personnelToUpdate.getEmail());
                }
                if (personnel.getPassword() != null) {
                    personnelToUpdate.setPassword(personnelToUpdate.getPassword());
                }

                Personnel updatedPersonnel = personnelRepository.save(personnelToUpdate);
                return ResponseEntity.ok(updatedPersonnel);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @Override
        public ResponseEntity<Void> deletePersonnel(Long id) {
            Optional<Personnel> optionalPersonnel = personnelRepository.findById(id);

            if (optionalPersonnel.isPresent()) {
                Personnel personnelToDelete = optionalPersonnel.get();
                personnelRepository.delete(personnelToDelete);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }

}
