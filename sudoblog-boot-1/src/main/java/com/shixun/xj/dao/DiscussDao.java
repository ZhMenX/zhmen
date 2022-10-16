package com.shixun.xj.dao;

import com.shixun.xj.entity.Discuss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author zhMen
 * @createTime 2022/9/23 21:57
 * @ClassName DiscussDao
 * @Version v1.0
 * @Description
 */
public interface DiscussDao extends JpaRepository<Discuss, Integer>, JpaSpecificationExecutor<Discuss> {
}
