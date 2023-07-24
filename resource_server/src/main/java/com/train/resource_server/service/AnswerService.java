package com.train.resource_server.service;

import org.springframework.stereotype.Service;
import com.train.resource_server.entity.Answer;
import com.train.resource_server.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

}
