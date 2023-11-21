package com.AkmaDev.TaskManager.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Personnel(String personnelName, String password, String email) {
        this.personnelName = personnelName;
        this.password = password;
        this.email = email;
    }

    public Personnel() {

    }

    @Column(name = "personnelName")
    private String personnelName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
