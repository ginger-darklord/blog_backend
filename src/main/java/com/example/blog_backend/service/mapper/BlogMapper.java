package com.example.blog_backend.service.mapper;

import com.example.blog_backend.persistence.entities.Blog;
import com.example.blog_backend.service.dtos.BlogDto;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper extends AbstractMapper<Blog, BlogDto> {
    @Override
    public BlogDto mapToDto(Blog source) {
        return BlogDto.builder()
                .id(source.getId())
                .title(source.getTitle())
                .content(source.getContent())
                .author(source.getAuthor())
                .build();
    }
}
