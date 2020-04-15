package com.example.springbootdb02thymeleafs;

import com.example.springbootdb02thymeleafs.mapper.TbUserMapper;
import com.example.springbootdb02thymeleafs.mapper.TbUserXmlMapper;
import com.example.springbootdb02thymeleafs.service.TbUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootDb02ThymeleafsApplicationTests {

    @Resource
    TbUserMapper tbUserMapper;
    @Resource
    TbUserXmlMapper tbUserXmlMapper;

    @Autowired
    TbUserService tbUserService;
    @Test
    void contextLoads() {
        System.err.println("tbUserService======>"+tbUserService.getById(1).toString());
        System.err.println("tbUserMapper=======>"+tbUserMapper.selectById(1).toString());
        System.err.println("tbUserXmlMapper====>"+tbUserXmlMapper.getBillByBid(2).toString());
        System.err.println("tbUserXmlMapper====>"+tbUserXmlMapper.selectAll().toString());

    }
}
