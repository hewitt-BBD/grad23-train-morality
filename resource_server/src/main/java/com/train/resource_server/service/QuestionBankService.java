package com.train.resource_server.service;

import com.train.resource_server.entity.Choice;
import com.train.resource_server.entity.QuestionBank;
import com.train.resource_server.entity.QuestionChoice;
import com.train.resource_server.entity.QuestionWithChoices;
import com.train.resource_server.repository.ChoiceRepository;
import com.train.resource_server.repository.QuestionBankRepository;
import com.train.resource_server.repository.QuestionChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionBankService {
    private final QuestionBankRepository questionBankRepository;
    private final QuestionChoiceRepository questionChoiceRepository;
    private final ChoiceRepository choiceRepository;

    @Autowired
    public QuestionBankService(QuestionBankRepository questionBankRepository,
                               QuestionChoiceRepository questionChoiceRepository,
                               ChoiceRepository choiceRepository) {
        this.questionBankRepository = questionBankRepository;
        this.questionChoiceRepository = questionChoiceRepository;
        this.choiceRepository = choiceRepository;
    }

    public QuestionBank getQuestionById(Integer questionId) {

        return questionBankRepository.findById(questionId).orElse(null);
    }

    public QuestionWithChoices getQuestionWithChoicesById(Integer questionId) {
        QuestionBank questionBank = questionBankRepository.findById(questionId).orElse(null);
        // if question exists, get question choice ids by question id. put them in an array and
        // loop through to get choice object by id and return as type QuestionChoice
        if (questionBank != null) {
            List<QuestionChoice> questionChoices = questionChoiceRepository.findByQuestionId(questionId);
            List<Choice> choices = new ArrayList<>();

            for (QuestionChoice questionChoice : questionChoices) {
                Integer choiceId = questionChoice.getChoiceId();
                Choice choice = choiceRepository.findById(choiceId).orElse(null);
                if (choice != null) {
                    choices.add(choice);
                }
            }
            return new QuestionWithChoices(questionBank, choices);
        }

        return null;
    }

    public List<QuestionWithChoices> getAllQuestionsAndChoices() {
        List<QuestionBank> questions = questionBankRepository.findAll();
        List<QuestionWithChoices> questionsAndChoices = new ArrayList<>();
        for (QuestionBank question:questions) {
            questionsAndChoices.add(getQuestionWithChoicesById(question.getQuestionId()));
        }
        return questionsAndChoices;
    }
}
