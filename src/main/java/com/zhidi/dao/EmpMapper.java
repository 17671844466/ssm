package com.zhidi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhidi.entity.Emp;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
    
    List<Emp> getAll();
    
    /**
     * 分页条件查询
     * @param firstResult 开始查询位置
     * @param maxResult 最大查询条数
     * @param params 查询条件
     * @return
     */
    List<Emp> getByPager(@Param("firstResult")Integer firstResult, 
    					 @Param("maxResult")Integer maxResult, 
    					 @Param("params")Map<String, Object> params);
    
    /**
     * 查询总条数
     * @param params 查询条件
     * @return
     */
    Integer count(@Param("params")Map<String, Object> params);
}