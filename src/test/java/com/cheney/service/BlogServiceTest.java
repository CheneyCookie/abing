package com.cheney.service;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cheney.model.Blog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTest {

    @Autowired
    private BlogService blogService;

    public void testSaveBlog(Blog blog) {

    }

    public Blog testFindById(String id) {
        return null;
    }

    public List<Blog> testFindByTitle(String title, int pageNum) {
        return null;
    }
    public List<Blog> findByTag(String tagName, int pageNum) {
        return null;
    }
}
