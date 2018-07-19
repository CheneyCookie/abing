package com.cheney.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.cheney.model.Tag;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagServiceTest {

    @Autowired
    private TagService tagService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testSaveTag() {
        Tag tag = new Tag();
        tag.setName("工作");
        tagService.saveTag(tag);
        System.out.println(tag);
    }

    @Test
    public void testGetById() {
        Query query = new Query(Criteria.where("id").is("5b1d0b3a121ca424381bae5e"));
        Tag tag = mongoTemplate.findOne(query, Tag.class);
        System.out.println(tag);
    }

    public List<Tag> findTags() {
        return null;
    }
}
