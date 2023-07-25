package com.train.resource_server.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.train.resource_server.entity.QuestionChoiceId;
import com.train.resource_server.entity.QuestionChoice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionChoiceRepository extends JpaRepository<QuestionChoice, QuestionChoiceId> {
    List<QuestionChoice> findByQuestionId(Integer questionId);
}