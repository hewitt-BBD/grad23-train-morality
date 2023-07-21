package com.train.resource_server.entity;

import jakarta.persistence.*;

@Entity
public class QuestionBank {

    @Id
    @Column(name = "QuestionID")
    private Integer questionId;

    @Column(name = "QuestionText", length = 800)
    private String questionText;

    // Constructors, getters, setters, etc.
}