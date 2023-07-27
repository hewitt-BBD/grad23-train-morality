package com.train.resource_server.service;

import com.train.resource_server.entity.Users;
import com.train.resource_server.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public Users getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public Users getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public Users createUser(Users user) {
        return userRepo.save(user);
    }
}
