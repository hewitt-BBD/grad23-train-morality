package com.train.resource_server.services;

import com.train.resource_server.entity.User;
import com.train.resource_server.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public User createUser(User user) {
        // You can add any additional logic before saving the entity.
        return userRepo.save(user);
    }
}
