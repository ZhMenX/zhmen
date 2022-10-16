package com.shixun.xj.dao;

import com.shixun.xj.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    User findByUserName(String username);

    //查询权限Id
    @Query(nativeQuery = true, value = "select * from sys_user_role where `user_id` = ?")
    List<Long> searchRoleId(@Param("id") Long id);
}
