package com.train.resource_server.entity;

import jakarta.persistence.*;

import java.io.Serializable;

 class QuestionChoiceId implements Serializable {
    private Integer questionId;
    private Integer choiceId;

    // Constructors, getters, setters, equals, and hashCode methods.
}

@Entity
@IdClass(QuestionChoiceId.class) // Composite primary key class (see below)
@Table(name = "questionchoice")
public class QuestionChoice {

    @Id
    @Column(name = "QuestionID")
    private Integer questionId;

    @Id
    @Column(name = "ChoiceID")
    private Integer choiceId;

    // Constructors, getters, setters, etc.
}