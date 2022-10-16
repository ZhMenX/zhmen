package com.shixun.xj.service.impl;

import com.shixun.xj.common.ResponseResult;
import com.shixun.xj.entity.LoginUser;
import com.shixun.xj.entity.User;
import com.shixun.xj.service.LoginService;
import com.shixun.xj.service.UserService;
import com.shixun.xj.util.JwtUtil;
import com.shixun.xj.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhMen
 * @createTime 2022/9/28 22:04
 * @ClassName LoginServiceImpl
 * @Version v1.0
 * @Description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {

        //AuthenticationManager authenticate 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        System.out.println("这里认证是"+authenticate.isAuthenticated());
        System.out.println(authenticate);
        //保存认证信息
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        //如果认证没有通过，给出对应的提示
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }


        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        //SecurityContextHolder.setContext((SecurityContext) loginUser);
        String userid = loginUser.getUser().getId().toString();
        //如果认证通过了，使用userid生成一个jwt  jwt存入ResponseResult返回
        String jwt = JwtUtil.createJWT(userid);
        //判断是否是管理员登录
        Integer judgeAdmin = userService.judgeAdmin(loginUser.getUser().getId());
        Map<String,Object> map = new HashMap<>();
        map.put("isAdmin",judgeAdmin);
        map.put("token",jwt);
        map.put("username",loginUser.getUser().getUserName());

        //把完整的用户信息存入redis userid作为key   token
        redisCache.setCacheObject("login:"+userid,loginUser);

        return new ResponseResult(200,"登录成功",map);
    }

    @Override
    public ResponseResult logout() {
        //获取SecurityContextHolder中的用户id
//        UsernamePasswordAuthenticationToken authentication =
//                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
//        Long userid = loginUser.getUser().getId();

        SecurityContextHolder.clearContext();
        //删除redis中的值
        //redisCache.deleteObject("login:"+userid);
        return new ResponseResult(200,"注销成功");
    }
}
