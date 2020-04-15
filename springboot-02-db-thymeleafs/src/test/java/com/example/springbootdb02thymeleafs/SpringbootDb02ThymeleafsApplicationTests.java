package com.example.springbootdb02thymeleafs;

import com.example.springbootdb02thymeleafs.mapper.TbUserMapper;
import com.example.springbootdb02thymeleafs.mapper.TbUserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootDb02ThymeleafsApplicationTests {

    @Resource
    TbUserMapper tbUserMapper;
    @Resource
    TbUserXmlMapper tbUserXmlMapper;
    @Test
    void contextLoads() {
        System.out.println(tbUserMapper.selectById(1).toString());
        System.out.println(tbUserXmlMapper.getBillByBid(2).toString());
        System.out.println(tbUserXmlMapper.selectAll().toString());


    }
}
