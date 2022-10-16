package com.shixun.xj.service.impl;

/**
 * @author zhMen
 * @createTime 2022/9/28 21:08
 * @ClassName UserDetailsServiceImpl
 * @Version v1.0
 * @Description
 */

import com.shixun.xj.dao.MenuDao;
import com.shixun.xj.dao.UserDao;
import com.shixun.xj.entity.LoginUser;
import com.shixun.xj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userMapper;

    @Autowired
    private MenuDao menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //1,查询用户信息
        User user = userMapper.findByUserName(username);
        //如何没有查询到用户，就抛出异常

        if (Objects.isNull(user)){
            throw  new RuntimeException("用户名或密码错误");
        }

        //TODO 查询对应的权限信息
        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        //3,封装成userdtails对象
        return new LoginUser(user,list);
    }
}


