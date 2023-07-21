package com.train.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.train.resource_server.entity.QuestionBank;

public interface QuestionBankRepository extends JpaRepository<QuestionBank, Integer>{
    //custom queries here
}
