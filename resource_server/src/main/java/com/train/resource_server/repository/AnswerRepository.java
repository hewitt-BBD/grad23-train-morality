package com.train.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.train.resource_server.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    // Custom queries (if needed)
}
