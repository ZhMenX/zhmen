package com.shixun.xj.controller;

import com.shixun.xj.common.Result;
import com.shixun.xj.entity.Blog;
import com.shixun.xj.entity.Discuss;
import com.shixun.xj.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author zhMen
 * @createTime 2022/9/23 22:03
 * @ClassName Dis_JavaController
 * @Version v1.0
 * @Description
 */
@RestController
public class DiscussController {

    @Autowired
    private DiscussService discussService;

    @GetMapping("/comment")
    @PreAuthorize("hasAnyAuthority('aricle','disucss','system:aricle:list','system:discuss:list')")
    public Result list() {
        List<Discuss> discussList = discussService.searchDiscuss();
        long total = (long) discussList.size();
        return Result.success(discussList, total);
    }

    @GetMapping("/comment/{id}")
    @PreAuthorize("hasAnyAuthority('aricle','disucss','system:aricle:list','system:discuss:list')")
    public Result search(@PathVariable Integer id) {
        Optional<Discuss> optional = discussService.searchById(id);
        Discuss discuss = optional.get();
        return Result.success(discuss, (long) 1);
    }

}
