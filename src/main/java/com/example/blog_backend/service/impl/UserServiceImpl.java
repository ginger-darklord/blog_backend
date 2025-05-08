package com.example.blog_backend.service.impl;

import com.example.blog_backend.persistence.entities.User;
import com.example.blog_backend.persistence.repositories.UserRepository;
import com.example.blog_backend.service.UserService;
import com.example.blog_backend.service.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDto user) {
        User entity = User.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
        System.out.println(entity);
        userRepository.save(entity);
    }

    @Override
    public void updateUser(Long id, UserDto user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with the id: " + id + " not found"));

        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with the id: " + id + " not found"));
        userRepository.delete(existingUser);
    }

    @Override
    public boolean logIn(UserDto user) {
        User existingUser = userRepository.findByName(user.getName());
            return true;
    }
}
