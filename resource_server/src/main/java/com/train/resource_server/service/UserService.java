package com.train.resource_server.service;

import com.train.resource_server.entity.Users;
import com.train.resource_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users getUserById(Integer userId) {

        return userRepository.findById(userId).orElse(null);
    }
}
