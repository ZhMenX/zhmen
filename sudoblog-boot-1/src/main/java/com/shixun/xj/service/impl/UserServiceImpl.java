package com.shixun.xj.service.impl;

import com.shixun.xj.common.ResponseResult;
import com.shixun.xj.dao.UserDao;
import com.shixun.xj.entity.User;
import com.shixun.xj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhMen
 * @createTime 2022/10/1 10:34
 * @ClassName UserServiceImpl
 * @Version v1.0
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;
    @Override
    public ResponseResult register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userInfo = userDao.save(user);
        return new ResponseResult(200,"注册成功",userInfo);
    }

    //判断是否是管理员登录
    @Override
    public Integer judgeAdmin(Long id) {
        List<Long> list = userDao.searchRoleId(id);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1){
                return 1;
            }
        }
        return 0;
    }





}
