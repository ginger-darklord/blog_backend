package com.example.blog_backend.service.mapper;

public interface Mapper<S, T> {
    T mapToDto(S source);
}
