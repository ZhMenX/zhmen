package com.shixun.xj.service.impl;

import com.shixun.xj.dao.BlogDao;
import com.shixun.xj.entity.Blog;
import com.shixun.xj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author zhMen
 * @createTime 2022/9/19 9:40
 * @ClassName BlogServiceImpl
 * @Version v1.0
 * @Description
 */
@Service
@Transactional
@CacheConfig(cacheNames = "blog")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;


    //@Cacheable(value ="blogs",key = "#page")
    @Override
    public Page<Blog> search(Integer page, Integer size) {

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return blogDao.findAll(pageRequest);
    }

    @Cacheable(value = "blogDetail", key = "#id")
    @Override
    public Optional<Blog> searchById(Integer id) {
        return blogDao.findById(id);
    }

    @Override
    public List<Blog> searchByTitle(String name) {

        return blogDao.SearchByTitle(name);
    }
    //新增博客
    @Override
    public Blog add(Blog blog) {
        return blogDao.save(blog);
    }
    //删除博客
    @Override
    public void delete(Integer id) {
        Optional<Blog> blog = blogDao.findById(id);
        blogDao.delete(blog.get());
    }





}
