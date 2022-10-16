package com.shixun.xj.service;

import com.shixun.xj.entity.Learn;

import java.util.List;

/**
 * @author zhMen
 * @createTime 2022/10/12 16:52
 * @ClassName LearnService
 * @Version v1.0
 * @Description
 */
public interface LearnService {

    List<Learn>  searchLearn(Integer id);
}
