package com.cheney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.model.Tag;
import com.cheney.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    public TagController() {
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Tag saveTag(@RequestBody Tag tag) {
        tagService.saveTag(tag);
        return tag;
    }

    @RequestMapping(value="", method = RequestMethod.PUT)
    public Tag updateTag(@RequestBody Tag tag) {
        tagService.updateTag(tag);
        return tag;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Tag> findTags() {
        return tagService.findTags();
    }
}
