package com.example.blog_backend.service.impl;

import com.example.blog_backend.persistence.entities.Blog;
import com.example.blog_backend.persistence.repositories.BlogRepository;
import com.example.blog_backend.service.BlogService;
import com.example.blog_backend.service.dtos.BlogDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void createBlog(BlogDto blog) {
        Blog entity = Blog.builder()
                .title(blog.getTitle())
                .content(blog.getContent())
                .author(blog.getAuthor())
                .build();

        blogRepository.save(entity);
    }

    @Override
    public void updateBlog(Long id, BlogDto blog) {
        Blog existingEntity = blogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Blog post with this id has not been found"));

        existingEntity.setTitle(blog.getTitle());
        existingEntity.setContent(blog.getContent());

        blogRepository.save(existingEntity);
    }

    @Override
    public void deleteBlog(String id) {
        blogRepository.unsafeDeleteById(id);
        //Blog existingEntity = blogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Blog post with this id has not been found"));
        //blogRepository.delete(existingEntity);
    }

    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> getBlogsByTitle(String title) {
        return List.of();
    }
}
