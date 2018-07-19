package com.cheney.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.cheney.dao.BlogDao;
import com.cheney.model.Blog;
import com.cheney.util.StringUtil;

@Repository
public class BlogDaoImpl implements BlogDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public BlogDaoImpl() {
    }

    @Override
    public void saveBlog(Blog blog) {
        mongoTemplate.save(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        Query query = new Query(Criteria.where("id").is(blog.getId()));
        Update update = new Update();
        update.set("title", blog.getTitle());
        update.set("content", blog.getContent());
        update.set("updateTime", new Date());
        update.set("tags", blog.getTags());
        mongoTemplate.updateFirst(query, update, Blog.class);
    }

    @Override
    public Blog findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Blog blog = mongoTemplate.findOne(query, Blog.class);
        return blog;
    }

    @Override
    public List<Blog> listBlog(String title, String tagName, int pageNum) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (!StringUtil.isNullOrEmpty(title)) {
            criteria.and("title").regex("^.*" + title + ".*$", "i");
        }
        if (!StringUtil.isNullOrEmpty(tagName)) {
            criteria.and("tags.name").regex(tagName);
        }

        query.addCriteria(criteria);
        query.skip((pageNum - 1) * 10);
        query.limit(10).with(new Sort(Direction.DESC, "writeTime"));
        List<Blog> blogs = mongoTemplate.find(query, Blog.class);
        return blogs;
    }

    @Override
    public Long countBlog(String title, String tagName) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (!StringUtil.isNullOrEmpty(title)) {
            criteria.and("title").regex("^.*" + title + ".*$", "i");
        }
        if (!StringUtil.isNullOrEmpty(tagName)) {
            criteria.and("tags.name").regex(tagName);
        }

        query.addCriteria(criteria);
        long count = mongoTemplate.count(query, Blog.class);
        return count;
    }
}
