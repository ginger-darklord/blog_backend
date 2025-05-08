package com.example.blog_backend.persistence.repositories;

import com.example.blog_backend.persistence.entities.User;

public interface UnsafeUserRepository {
    public User findByNameUnsafe(String name, String password);
}
