package com.shixun.xj.service.impl;

import com.shixun.xj.dao.LearnDao;
import com.shixun.xj.entity.Learn;
import com.shixun.xj.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author zhMen
 * @createTime 2022/10/12 16:52
 * @ClassName LearnServiceImpl
 * @Version v1.0
 * @Description
 */
@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    private LearnDao learnDao;


    @Override
    public List<Learn> searchLearn(Integer id) {
        return learnDao.SearchAllLearns(id);
    }
}
