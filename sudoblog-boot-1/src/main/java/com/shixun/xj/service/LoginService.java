package com.shixun.xj.service;

import com.shixun.xj.common.ResponseResult;
import com.shixun.xj.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
