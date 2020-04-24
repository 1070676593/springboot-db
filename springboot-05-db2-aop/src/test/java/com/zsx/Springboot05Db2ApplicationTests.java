package com.zsx;

import com.zsx.mapper.TbUserXml2Mapper;
import com.zsx.mapper.TbUserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Springboot05Db2ApplicationTests {

    @Autowired
    TbUserXmlMapper tbUserXmlMapper;

    @Autowired
    TbUserXml2Mapper tbUserXml2Mapper;


    @Test
    void contextLoads() {
        System.out.println(tbUserXmlMapper.getBillByBid(1));
        System.out.println(tbUserXml2Mapper.getBillByBid(1));
    }

}
