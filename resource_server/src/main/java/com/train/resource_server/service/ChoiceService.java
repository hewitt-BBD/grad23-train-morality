package com.train.resource_server.service;

import com.train.resource_server.entity.Choice;
import com.train.resource_server.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceService {

    private final ChoiceRepository choiceRepository;

    @Autowired
    public ChoiceService(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    public Choice getChoiceById(Integer choiceId) {

        return choiceRepository.findById(choiceId).orElse(null);
    }
}