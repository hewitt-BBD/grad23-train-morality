package com.train.resource_server.entity;

import jakarta.persistence.*;

@Entity
public class QuestionBank {

    @Id
    @Column(name = "QuestionID")
    private Integer questionId;

    @Column(name = "question_text", length = 800)
    private String questionText;

    public QuestionBank() {

    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}