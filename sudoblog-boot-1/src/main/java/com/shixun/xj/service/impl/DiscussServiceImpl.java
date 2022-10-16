package com.shixun.xj.service.impl;

import com.shixun.xj.dao.DiscussDao;
import com.shixun.xj.entity.Discuss;
import com.shixun.xj.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author zhMen
 * @createTime 2022/9/23 22:00
 * @ClassName Dis_JavaServiceImpl
 * @Version v1.0
 * @Description
 */
@Service
@CacheConfig(cacheNames = "comment")
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussDao discussDao;

    @Override
    public Page<Discuss> search(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return discussDao.findAll(pageRequest);
    }

    @Cacheable(value = "discusses")
    @Override
    public List<Discuss> searchDiscuss() {
        return discussDao.findAll();
    }

    @Cacheable(value = "discuss", key = "#id")
    @Override
    public Optional<Discuss> searchById(Integer id) {
        return discussDao.findById(id);
    }
}
