package com.shixun.xj.controller;

import com.shixun.xj.common.Result;
import com.shixun.xj.entity.Blog;
import com.shixun.xj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * @author zhMen
 * @createTime 2022/9/19 9:47
 * @ClassName BlogController
 * @Version v1.0
 * @Description
 */
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    //博客模糊查询,这里不符合Restful风格，以后要处理
    @GetMapping("/articleLike")
    @PreAuthorize("hasAnyAuthority('aricle','disucss','system:aricle:list','system:discuss:list')")
    public Result ArticleSearch(@RequestParam("title") String title){
        List<Blog> blogs = blogService.searchByTitle(title);
        return Result.success(blogs, (long) blogs.size());
    }

    //使用Get请求获取博客列表
    @GetMapping("/article")
    @PreAuthorize("hasAnyAuthority('aricle','disucss','system:aricle:list','system:discuss:list')")
    public Result list(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize) {

        Page<Blog> blogs = blogService.search(currentPage, pageSize);
        return Result.success(blogs, blogs.getTotalElements());
    }

    //新增，更新博客
    @PostMapping("/article")
    @PreAuthorize("hasAnyAuthority('aricle','disucss','system:aricle:list','system:discuss:list')")
    public Result BlogAdd(@RequestBody Blog blog){
        Blog blogNew = blogService.add(blog);
        return  Result.success("新增成功！",(long)blogNew.getId());
    }
    //删除博客
    @DeleteMapping("/article/{id}")
    @PreAuthorize("hasAnyAuthority('aricle','disucss','system:aricle:list','system:discuss:list')")
    public Result BlogDel(@PathVariable("id") Integer id){
        blogService.delete(id);
        return  Result.success("删除成功！",(long)1);
    }

}
