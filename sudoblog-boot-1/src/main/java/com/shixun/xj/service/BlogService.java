package com.shixun.xj.service;

import com.shixun.xj.entity.Blog;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface BlogService {

    Page<Blog> search(Integer page, Integer size);

    Optional<Blog> searchById(Integer id);


    List<Blog> searchByTitle(String name);


}
