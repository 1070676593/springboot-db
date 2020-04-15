package com.example.springbootdb02thymeleafs.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdb02thymeleafs.entity.TbUser;
import org.apache.ibatis.annotations.Select;

/**
 * @CalssName: TbUserMapper
 * @Author: zsx
 * @Date: 2020/4/7 15:40
 **/
public interface TbUserMapper extends BaseMapper<TbUser> {

//    @Select("select * from tb_user where id=#{id}")
//    TbUser selectById(int id);
}
