package com.train.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.train.resource_server.entity.QuestionChoice;

public interface QuestionChoiceRepository extends JpaRepository<QuestionChoice, QuestionChoice> {
    // Custom queries (if needed)
}