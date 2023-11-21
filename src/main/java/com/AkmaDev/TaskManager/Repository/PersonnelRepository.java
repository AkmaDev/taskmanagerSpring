package com.AkmaDev.TaskManager.Repository;

import com.AkmaDev.TaskManager.Model.Personnel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
   List<Personnel> findByPersonnelName(String personnelName);
}
