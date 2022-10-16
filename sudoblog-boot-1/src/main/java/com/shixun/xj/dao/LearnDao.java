package com.shixun.xj.dao;

import com.shixun.xj.entity.Learn;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LearnDao  extends JpaRepository<Learn, Integer>, JpaSpecificationExecutor<Learn> {


    @Query(nativeQuery = true,value = "select * from learn where tid = ?")
    List<Learn> SearchAllLearns (@Param("id") int id);

}
