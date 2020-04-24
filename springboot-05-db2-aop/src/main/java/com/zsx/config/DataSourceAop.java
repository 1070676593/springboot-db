package com.zsx.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


/**
 * @CalssName: DataSourceAop
 * @Author: zsx
 * @Date: 2020/4/23 17:12
 **/
@Aspect
@Component
public class DataSourceAop {

    //默认就是data1数据源，所以可以不写一下aop
//    @Before("execution(* com.zsx.mapper.*XmlMapper.*(..))")
//    @Primary
//    public void setDataSourceData1(){
//        System.out.println("data1数据源业务");
//        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DATA1);
//    }

    @Before("execution(* com.zsx.mapper.*Xml2Mapper.*(..))")
    public void setDataSourceData2(){
        System.out.println("data2数据源业务");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DATA2);
    }
}
