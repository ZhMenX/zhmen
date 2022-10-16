package com.shixun.xj.handler;

import com.alibaba.fastjson.JSON;

import com.shixun.xj.common.ResponseResult;
import com.shixun.xj.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhMen
 * @createTime 2022/9/29 18:13
 * @ClassName AccessDeniedHandlerImpl
 * @Version v1.0
 * @Description
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "权限不足");

        String json = JSON.toJSONString(result);

        WebUtils.renderString(response,json);

    }
}

