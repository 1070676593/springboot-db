package com.zsx.springbootdb01thymeleaf;

import com.zsx.springbootdb01thymeleaf.mapper.TbUserMapper;
import com.zsx.springbootdb01thymeleaf.mapper.TbUserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootDb01ThymeleafApplicationTests {

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
