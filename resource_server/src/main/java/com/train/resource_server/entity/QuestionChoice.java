package com.train.resource_server.entity;

import jakarta.persistence.*;
@Entity
public class QuestionChoice {

    @Id
    @ManyToOne
    @JoinColumn(name = "QuestionID")
    private QuestionBank question;

    @Id
    @ManyToOne
    @JoinColumn(name = "ChoiceID")
    private Choice choice;

    // Constructors, getters, setters, etc.
}