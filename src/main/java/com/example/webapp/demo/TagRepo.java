package com.example.webapp.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface TagRepo extends CrudRepository<Tag, String> {


}
