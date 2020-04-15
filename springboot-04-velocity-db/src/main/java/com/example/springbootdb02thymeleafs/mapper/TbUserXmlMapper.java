package com.example.springbootdb02thymeleafs.mapper;



import com.example.springbootdb02thymeleafs.entity.TbUser;

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
