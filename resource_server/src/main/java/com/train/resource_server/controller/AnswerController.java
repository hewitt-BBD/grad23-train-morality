package com.train.resource_server.controller;

import com.train.resource_server.entity.Choice;
import com.train.resource_server.entity.QuestionBank;
import com.train.resource_server.entity.Users;
import com.train.resource_server.service.ChoiceService;
import com.train.resource_server.service.QuestionBankService;
import com.train.resource_server.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.train.resource_server.entity.Answer;
import com.train.resource_server.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AnswerController {

    private final AnswerService answerService;
    private final ChoiceService choiceService;
    private final QuestionBankService questionBankService;
    private final UserService userService;

    @Autowired
    public AnswerController(AnswerService answerService, ChoiceService choiceService, QuestionBankService questionBankService, UserService userService) {
        this.answerService = answerService;
        this.choiceService = choiceService;
        this.questionBankService = questionBankService;
        this.userService = userService;
    }

    @PostMapping("/answers")
    public Answer createAnswer(@RequestBody Answer newAnswer) {

        // Fetch the Choice entity from the database using the choiceId
        QuestionBank questionBank = questionBankService.getQuestionById(newAnswer.getQuestion().getQuestionId());
        newAnswer.setQuestion(questionBank);

        Choice choice = choiceService.getChoiceById(newAnswer.getChoice().getChoiceId());
        newAnswer.setChoice(choice);

        Users user = userService.getUserById(newAnswer.getUser().getUserId());
        newAnswer.setUser(user);


        return answerService.saveAnswer(newAnswer);
    }
}