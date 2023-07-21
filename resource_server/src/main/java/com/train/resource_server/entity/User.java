package com.train.resource_server.entity;
import jakarta.persistence.*;


@Entity
public class User {

    @Id
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "Username", length = 255)
    private String username;

    @Column(name = "EmailAddress", length = 255)
    private String emailAddress;

    // Constructors, getters, setters, etc.
}