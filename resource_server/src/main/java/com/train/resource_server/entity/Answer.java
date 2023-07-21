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
    @JoinColumn(name = "QuestionID") // Ensure the case matches the actual column name in the QuestionBank table.
    private QuestionBank question;

    @ManyToOne
    @JoinColumn(name = "ChoiceID")
    private Choice choice;

    // Constructors, getters, setters, etc.
}