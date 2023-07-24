package com.train.resource_server.service;

import com.train.resource_server.entity.Choice;
import com.train.resource_server.entity.QuestionBank;
import com.train.resource_server.repository.ChoiceRepository;
import com.train.resource_server.repository.QuestionBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionBankService {
    private final QuestionBankRepository questionBankRepository;

    @Autowired
    public QuestionBankService(QuestionBankRepository questionBankRepository) {
        this.questionBankRepository = questionBankRepository;
    }

    public QuestionBank getQuestionById(Integer questionId) {

        return questionBankRepository.findById(questionId).orElse(null);
    }
}
