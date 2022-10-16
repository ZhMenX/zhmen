package com.shixun.xj.dao;

import com.shixun.xj.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhMen
 * @createTime 2022/9/30 9:34
 * @ClassName MenuDao
 * @Version v1.0
 * @Description
 */
@Component
public interface MenuDao extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor<Menu> {

    @Query(nativeQuery = true,
            value ="select DISTINCT m.`perms` from sys_user_role ur LEFT JOIN `sys_role` r ON ur.`role_id` = r.`id` LEFT JOIN `sys_role_menu` rm ON ur.`role_id` = rm.`role_id` LEFT JOIN `sys_menu` m ON m.`id` = rm.`menu_id` WHERE user_id = ? AND r.`status` = 0  AND m.`status` = 0 ")
    List<String> selectPermsByUserId(@Param("userid") Long id);
}
