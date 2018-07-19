package com.cheney.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheney.dao.BlogDao;
import com.cheney.model.Blog;
import com.cheney.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    public BlogServiceImpl() {
    }

    @Override
    public void saveBlog(Blog blog) {
        blog.setWriteTime(new Date());
        blogDao.saveBlog(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogDao.updateBlog(blog);
    }

    @Override
    public Blog findById(String id) {
        return blogDao.findById(id);
    }

    @Override
    public List<Blog> listBlog(String title, String tagName, int pageNum) {
        return blogDao.listBlog(title, tagName, pageNum);
    }

    @Override
    public Long countBlog(String title, String tagName) {
        return blogDao.countBlog(title, tagName);
    }

}
