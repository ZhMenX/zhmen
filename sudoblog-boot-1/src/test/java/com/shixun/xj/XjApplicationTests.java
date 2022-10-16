package com.shixun.xj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
class XjApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication().getPrincipal());
    }

}
