package com.train.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.train.resource_server.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    // Custom queries here
}
