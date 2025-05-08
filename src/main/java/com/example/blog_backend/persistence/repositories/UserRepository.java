package com.example.blog_backend.persistence.repositories;

import com.example.blog_backend.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UnsafeUserRepository { //also extends UnsafeUserRepository so Spring can inject it into UserRepository yeah
    public User findByName(String name);
}
