package com.train.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.train.resource_server.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT u FROM User u")
    List<User> getAllUsers();
}
