package com.train.resource_server.entity;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    @Column(name = "Username", length = 255)
    private String username;

    @Column(name = "EmailAddress", length = 255)
    private String emailAddress;

    // Constructors, getters, setters, etc.
}