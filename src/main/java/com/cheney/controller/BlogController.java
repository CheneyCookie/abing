package com.cheney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.model.Blog;
import com.cheney.service.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    public BlogController() {
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Blog saveBlog(@RequestBody Blog blog) {
        blogService.saveBlog(blog);
        return blog;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Blog updateBlog(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
        return blog;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Blog findById(@PathVariable String id) {
        return blogService.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Blog> listBlog(@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String tagName, @RequestParam(defaultValue = "1") int pageNum) {
        return blogService.listBlog(title, tagName, pageNum);
    }

    @RequestMapping(value = "count", method = RequestMethod.GET)
    public Long countBlog(@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String tagName) {
        return blogService.countBlog(title, tagName);
    }

}
