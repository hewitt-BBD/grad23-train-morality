package com.train.resource_server.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "Username", length = 255)
    private String username;

    @Column(name = "EmailAddress", length = 255)
    private String emailAddress;

    public User() {
    }

    public User(Integer userId, String username, String emailAddress) {
        this.userId = userId;
        this.username = username;
        this.emailAddress = emailAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}