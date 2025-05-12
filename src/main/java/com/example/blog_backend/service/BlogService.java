package com.example.blog_backend.service;

import com.example.blog_backend.persistence.entities.Blog;
import com.example.blog_backend.service.dtos.BlogDto;
import com.example.blog_backend.service.dtos.UserDto;

import java.util.List;

public interface BlogService {
    void createBlog(BlogDto blog);
    void updateBlog(Long id, BlogDto blog);
    void deleteBlog(String id);
    List<Blog> getBlogs();
    List<Blog> getBlogsByTitle(String title);
}
