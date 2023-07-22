package com.train.resource_server.controller;

import com.train.resource_server.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.train.resource_server.entity.Answer;
import com.train.resource_server.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/answers")
    public Answer createAnswer(@RequestBody Answer newAnswer) {
        return answerService.saveAnswer(newAnswer);
    }
}