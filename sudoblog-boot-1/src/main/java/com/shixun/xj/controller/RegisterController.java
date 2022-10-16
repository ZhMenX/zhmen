package com.shixun.xj.controller;

import com.shixun.xj.common.ResponseResult;
import com.shixun.xj.entity.User;
import com.shixun.xj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhMen
 * @createTime 2022/10/1 10:32
 * @ClassName RegisterController
 * @Version v1.0
 * @Description
 */
@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }
}
