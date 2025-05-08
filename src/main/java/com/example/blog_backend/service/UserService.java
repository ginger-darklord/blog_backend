package com.example.blog_backend.service;

import com.example.blog_backend.service.dtos.UserDto;

public interface UserService {
    void createUser(UserDto user);
    void updateUser(Long id, UserDto user);
    void deleteUser(Long id);
    boolean logIn(UserDto userDto);
}
