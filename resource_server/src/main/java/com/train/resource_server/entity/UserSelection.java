package com.train.resource_server.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@IdClass(UserQuestionId.class)
@Table(name = "UserSelection")
public class UserSelection {

    @Id
    @Column(name = "UserID")
    private Integer userId;

    @Id
    @Column(name = "QuestionID")
    private Integer questionId;

    @Column(name = "ChosenOption")
    private String option;

    public UserSelection(){}

    public Integer getUser() {
        return userId;
    }

    public Integer getQuestion() {
        return questionId;
    }

    public String getOption() {
        return option;
    }

    @Override
    public String toString() {
        return "UserSelection{" +
                "user=" + userId +
                ", question=" + questionId +
                ", option='" + option + '\'' +
                '}';
    }
}
