package com.train.resource_server.entity;

import jakarta.persistence.*;


@Entity
public class Choice {

    @Id
    @Column(name = "ChoiceID")
    private Integer choiceId;

    @Column(name = "ChoiceValue", length = 20)
    private String choiceValue;

    @Column(name = "ChoiceText", length = 255)
    private String choiceText;

    // Constructors, getters, setters, etc.
}