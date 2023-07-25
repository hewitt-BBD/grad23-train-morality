package com.train.resource_server.entity;

import jakarta.persistence.Entity;
import java.io.Serializable;


public class QuestionChoiceId implements Serializable {
    private Integer questionId;
    private Integer choiceId;

    // Constructors, getters, setters, equals, and hashCode methods.
}