package com.didi.db.mapper;

import com.didi.db.model.PayDO;
import org.apache.ibatis.annotations.Mapper;


public interface PayDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayDO record);

    int insertSelective(PayDO record);

    PayDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayDO record);

    int updateByPrimaryKey(PayDO record);
}