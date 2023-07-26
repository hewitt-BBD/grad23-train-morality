package com.train.resource_server.entity;

import jakarta.persistence.*;

@Entity
@IdClass(QuestionChoiceId.class) // Composite primary key class (see below)
@Table(name = "QuestionChoice")
public class QuestionChoice {

    @Id
    @Column(name = "QuestionID")
    private Integer questionId;

    @Id
    @Column(name = "ChoiceID")
    private Integer choiceId;

    public Integer getChoiceId() {
        return choiceId;
    }

    // Constructors, getters, setters, etc.
}