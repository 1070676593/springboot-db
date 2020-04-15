package com.zsx.springbootdb01thymeleaf.mapper;

import com.zsx.springbootdb01thymeleaf.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @CalssName: TbUserXmlMapper
 * @Author: zsx
 * @Date: 2020/4/7 15:54
 **/
public interface TbUserXmlMapper {

    TbUser getBillByBid(int id);

    List<TbUser> selectAll();
}
