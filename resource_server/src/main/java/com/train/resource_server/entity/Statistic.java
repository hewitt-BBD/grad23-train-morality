package com.train.resource_server.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "Stats")
public class Statistic {

    @Id
    @Column(name = "QuestionID")
    private Integer Question;

    @Column(name = "TotalOptionA")
    private Integer TotalA;

    @Column(name = "TotalOptionB")
    private Integer TotalB;

    public Statistic(){}

    public Integer getQuestion() {
        return Question;
    }

    public Integer getTotalA() {
        return TotalA;
    }

    public Integer getTotalB() {
        return TotalB;
    }
}
