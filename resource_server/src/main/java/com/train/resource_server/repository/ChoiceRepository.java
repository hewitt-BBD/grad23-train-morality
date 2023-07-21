package com.train.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.train.resource_server.entity.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Integer> {
    // Custom queries (if needed)
}
