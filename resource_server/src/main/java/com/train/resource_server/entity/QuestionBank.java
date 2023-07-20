package com.train.resource_server.entity;

import jakarta.persistence.*;
@Entity
public class QuestionBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestionID")
    private Long questionId;

    @Column(name = "QuestionText", length = 1000)
    private String questionText;

    // Constructors, getters, setters, etc.
}