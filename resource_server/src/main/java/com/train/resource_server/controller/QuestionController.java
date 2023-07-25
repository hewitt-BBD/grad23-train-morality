package com.train.resource_server.controller;

import com.train.resource_server.entity.QuestionWithChoices;
import com.train.resource_server.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionBankService questionBankService;

    @Autowired
    public QuestionController(QuestionBankService questionBankService) {
        this.questionBankService = questionBankService;
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionWithChoices> getQuestionWithChoices(@PathVariable Integer questionId) {
        QuestionWithChoices questionWithChoices = questionBankService.getQuestionWithChoicesById(questionId);
        if (questionWithChoices != null) {
            return ResponseEntity.ok(questionWithChoices);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
