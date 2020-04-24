package com.zsx;

import com.zsx.mapper.data1.TbUserMapper;
import com.zsx.mapper.data1.TbUserXmlMapper;
import com.zsx.mapper.data2.TbUserXml2Mapper;
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
