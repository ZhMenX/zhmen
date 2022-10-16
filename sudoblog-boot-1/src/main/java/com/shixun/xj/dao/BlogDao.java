package com.shixun.xj.dao;

import com.shixun.xj.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author zhMen
 * @createTime 2022/9/19 9:36
 * @ClassName BlogDao
 * @Version v1.0
 * @Description
 */
public interface BlogDao extends JpaRepository<Blog, Integer>, JpaSpecificationExecutor<Blog> {

    @Query(nativeQuery=true,value = "select * from blog where `title` like %?1%")
    List<Blog> SearchByTitle(String name);
}
