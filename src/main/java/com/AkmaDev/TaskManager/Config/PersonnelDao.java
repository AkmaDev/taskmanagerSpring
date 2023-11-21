package com.AkmaDev.TaskManager.Config;


import com.AkmaDev.TaskManager.Model.Personnel;
import com.AkmaDev.TaskManager.Repository.PersonnelRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;



@Component
public class PersonnelDao {

    @Autowired
    private final PersonnelRepository personnelRepository;

    public PersonnelDao(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @PostConstruct
    public void init() {
        /*
        String firstEncodedPassword = passwordEncoder.encode("password1");
        String secondEncodedPassword = passwordEncoder.encode("password2");
        */

        Personnel personnel1 = new Personnel("personnel1", "password1", "personnel1@gmail.com");
        personnelRepository.save(personnel1);


        Personnel personnel2 = new Personnel("personnel2", "password2", "personnel2@gmail.com");
        personnelRepository.save(personnel2);

    }
}
