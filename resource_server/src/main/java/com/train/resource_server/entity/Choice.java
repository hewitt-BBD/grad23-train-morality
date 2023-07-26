package com.train.resource_server.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Choice")
public class Choice {

    @Id
    @Column(name = "ChoiceID")
    private Integer choiceId;

    @Column(name = "ChoiceValue", length = 20)
    private String choiceValue;

    @Column(name = "ChoiceText", length = 255)
    private String choiceText;

    public Choice() {

    }
    public Integer getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
    }

    public String getChoiceValue() {
        return choiceValue;
    }

    public void setChoiceValue(String choiceValue) {
        this.choiceValue = choiceValue;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }
}