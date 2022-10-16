package com.shixun.xj.service;

import com.shixun.xj.common.ResponseResult;
import com.shixun.xj.entity.User;

public interface UserService {

    ResponseResult register(User user);


    Integer judgeAdmin(Long id);

}
