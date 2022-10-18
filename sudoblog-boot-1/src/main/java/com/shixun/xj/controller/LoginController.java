package com.shixun.xj.controller;

import com.shixun.xj.common.ResponseResult;
import com.shixun.xj.entity.User;
import com.shixun.xj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhMen
 * @createTime 2022/9/30 9:47
 * @ClassName LoginController
 * @Version v1.0
 * @Description
 */

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody  User user){
        //登录
        return loginService.login(user);
    }
    @PostMapping("/login")
    public ResponseResult AdminLogin(@RequestBody User user){
        System.out.println(user.getUserName()+"有没有");
        return loginService.login(user);
    }


    @GetMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }


    @PostMapping("testCors")
    public ResponseResult testCors(){
        return new ResponseResult(200,"testCors");
    }

}
