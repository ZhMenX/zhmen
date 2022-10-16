package com.shixun.xj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;


@SpringBootApplication
public class XjApplication {

    public static void main(String[] args) {
        SpringApplication.run(XjApplication.class, args);
    }

    //在使用Spring Boot JPA时，open-in-view 选项默认为true。启动时在日志中会出现警告。

    //解决办法：手动注册OpenEntityManagerInViewFilter过滤器，改变session的生命周期，当web请求关闭时才结束session。
    @Bean
    public FilterRegistrationBean<OpenEntityManagerInViewFilter> registerOpenEntityManagerInViewFilterBean() {
        FilterRegistrationBean<OpenEntityManagerInViewFilter> registrationBean = new FilterRegistrationBean<>();
        OpenEntityManagerInViewFilter filter = new OpenEntityManagerInViewFilter();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(5);
        return registrationBean;
    }


}
