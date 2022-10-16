package com.shixun.xj.controller;

import com.shixun.xj.common.Result;
import com.shixun.xj.entity.Learn;
import com.shixun.xj.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhMen
 * @createTime 2022/10/12 16:53
 * @ClassName LearnController
 * @Version v1.0
 * @Description
 */
@RestController
public class LearnController {

    @Autowired
    private LearnService learnService;

    @GetMapping("/learn/{lid}")
    public Result learn(@PathVariable Integer lid){
        List<Learn> list = learnService.searchLearn(lid);
        return Result.success(list, (long) list.size());
    }
}
