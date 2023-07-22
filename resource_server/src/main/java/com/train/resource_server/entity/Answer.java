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

    public Answer() {
    }

    // Getters and Setters
    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public QuestionBank getQuestion() {
        return question;
    }

    public void setQuestion(QuestionBank question) {
        this.question = question;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}