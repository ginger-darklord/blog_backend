package com.example.blog_backend.api;

import com.example.blog_backend.persistence.entities.Blog;
import com.example.blog_backend.service.BlogService;
import com.example.blog_backend.service.dtos.BlogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "blog")
@CrossOrigin(origins = "*")
public class BlogApi {
    private final BlogService blogService;

    @Autowired
    public BlogApi(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBlog(@RequestBody BlogDto blog) {
        blogService.createBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body("Blog created successfully");
    }

    @PutMapping("/update/{id}")
    public void updateBlog(@PathVariable Long id, @RequestBody BlogDto blog) { blogService.updateBlog(id, blog); }

    @DeleteMapping("/delete/{id}")
    public void deleteBlog(@PathVariable String id) { blogService.deleteBlog(id); }

    @GetMapping("/all")
    public List<Blog> getAllBlogs() {
        return blogService.getBlogs();
    }

}

