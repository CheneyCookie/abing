package com.cheney.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.cheney.dao.TagDao;
import com.cheney.model.Tag;

@Repository
public class TagDaoImpl implements TagDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public TagDaoImpl() {
    }

    @Override
    public void saveTag(Tag tag) {
        mongoTemplate.save(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        Query query = new Query(Criteria.where("id").is(tag.getId()));
        Update update = new Update();
        update.set("name", tag.getName());
        mongoTemplate.updateFirst(query, update, Tag.class);
    }

    @Override
    public List<Tag> findTags() {
        List<Tag> tags = mongoTemplate.findAll(Tag.class);
        return tags;
    }
}
