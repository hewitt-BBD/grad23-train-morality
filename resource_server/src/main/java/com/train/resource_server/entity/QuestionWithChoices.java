package com.train.resource_server.entity;

import jakarta.persistence.Entity;

import java.util.List;

public class QuestionWithChoices {
    private final QuestionBank question;
    private final List<Choice> choices;

    public QuestionWithChoices(QuestionBank question, List<Choice> choices) {
        this.question = question;
        this.choices = choices;
    }

    public QuestionBank getQuestion() {
        return question;
    }

    public List<Choice> getChoices() {
        return choices;
    }
}
