package com.project.dp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "email")
public class Emaill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Email(message = "Введен неккоректный email")
    @Column(name = "email")
    private String emailName;

    public Emaill(String emailName) {
        this.emailName = emailName;
    }

    public Emaill(){

    }

    public Emaill(int id, String email) {
        this.id = id;
        this.emailName = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }


}
