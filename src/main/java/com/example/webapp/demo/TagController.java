package com.example.webapp.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tags-rest")
public class TagController {


    @Autowired
    TagRepo tagRepo;

    @GetMapping(value= "/all", produces = "application/json")
    public Iterable<Tag> readAllTags() {
        return tagRepo.findAll();
    }
}
