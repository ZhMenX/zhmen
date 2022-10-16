package com.shixun.xj.service;

import com.shixun.xj.entity.Blog;
import com.shixun.xj.entity.Discuss;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DiscussService {
    Page<Discuss> search(Integer page, Integer size);

    List<Discuss> searchDiscuss();

    Optional<Discuss> searchById(Integer id);
}
