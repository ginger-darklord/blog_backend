package com.example.blog_backend.service.mapper;

import com.example.blog_backend.persistence.entities.User;
import com.example.blog_backend.service.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto>{
    @Override
    public UserDto mapToDto(User source) {
        return UserDto.builder()
                .id(source.getId())
                .name(source.getName())
                .email(source.getEmail())
                .password(source.getPassword())
                .build();
    }
}
