package com.example.blog_backend.persistence.repositories;

import com.example.blog_backend.persistence.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UnsafeUserRepositoryImpl implements UnsafeUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByNameUnsafe(String name, String password) {
        String sql = "SELECT * FROM app_user WHERE name = '" + name + "' AND password = '" + password + "'";
        return (User) entityManager
                .createNativeQuery(sql, User.class)
                .setParameter(1, name)
                .setParameter(2, password)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
