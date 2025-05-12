package com.example.blog_backend.persistence.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class UnsafeBlogRepositoryImpl implements UnsafeBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void unsafeDeleteById(String id) {
        String sql = "DELETE FROM blog WHERE id = " + id;
        entityManager.createNativeQuery(sql).executeUpdate();
    }
}
