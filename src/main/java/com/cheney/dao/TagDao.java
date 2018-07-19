package com.cheney.dao;

import java.util.List;

import com.cheney.model.Tag;

public interface TagDao {

    public void saveTag(Tag tag);

    public void updateTag(Tag tag);

    public List<Tag> findTags();

}
