package com.cheney.service;

import java.util.List;

import com.cheney.model.Blog;

public interface BlogService {

    void saveBlog(Blog blog);

    void updateBlog(Blog blog);

    Blog findById(String id);

    List<Blog> listBlog(String title, String tagName, int pageNum);

    Long countBlog(String title, String tagName);
}
