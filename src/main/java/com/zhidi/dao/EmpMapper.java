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
     * ��ҳ������ѯ
     * @param firstResult ��ʼ��ѯλ��
     * @param maxResult ����ѯ����
     * @param params ��ѯ����
     * @return
     */
    List<Emp> getByPager(@Param("firstResult")Integer firstResult, 
    					 @Param("maxResult")Integer maxResult, 
    					 @Param("params")Map<String, Object> params);
    
    /**
     * ��ѯ������
     * @param params ��ѯ����
     * @return
     */
    Integer count(@Param("params")Map<String, Object> params);
}