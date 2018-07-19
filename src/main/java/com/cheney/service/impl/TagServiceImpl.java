package com.cheney.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheney.dao.TagDao;
import com.cheney.model.Tag;
import com.cheney.service.TagService;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    public TagServiceImpl() {
    }

    @Override
    public void saveTag(Tag tag) {
        tagDao.saveTag(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        tagDao.updateTag(tag);
    }

    @Override
    public List<Tag> findTags() {
        List<Tag> tags = tagDao.findTags();
        return tags;
    }
}
