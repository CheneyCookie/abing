package com.cheney.service;

import java.util.List;

import com.cheney.model.Tag;

public interface TagService {

    void saveTag(Tag tag);

    void updateTag(Tag tag);

    List<Tag> findTags();
}
