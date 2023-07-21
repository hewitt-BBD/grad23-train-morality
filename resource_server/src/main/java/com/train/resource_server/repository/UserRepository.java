package com.train.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.train.resource_server.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom queries here
}
