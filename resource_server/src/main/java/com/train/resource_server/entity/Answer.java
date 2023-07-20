package com.train.resource_server.entity;

import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AnswerID")
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "QuestionID")
    private QuestionBank question;

    @ManyToOne
    @JoinColumn(name = "ChoiceID")
    private Choice choice;

    // Constructors, getters, setters, etc.
}