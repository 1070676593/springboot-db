package com.zsx.springbootdb01thymeleaf.mapper;

import com.zsx.springbootdb01thymeleaf.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @CalssName: TbUserMapper
 * @Author: zsx
 * @Date: 2020/4/7 15:40
 **/
public interface TbUserMapper{

    @Select("select * from tb_user where id=#{id}")
    TbUser selectById(int id);
}
