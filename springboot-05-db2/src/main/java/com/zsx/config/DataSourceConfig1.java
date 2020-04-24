package com.zsx.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @CalssName: DataSourceConfig1
 * @Author: zsx
 * @Date: 2020/4/23 13:37
 **/
@Configuration
@MapperScan(basePackages = "com.zsx.mapper.data1",sqlSessionFactoryRef = "data1SqlSessionFactory")
public class DataSourceConfig1 {
    @Bean("data1DataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.data1")
    public DataSource getDataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean("data1SqlSessionFactory")
    @Primary
    public SqlSessionFactory data1SqlSessionFactory(@Qualifier("data1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                //设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/data1/*.xml")
        );
        return bean.getObject();
    }

    @Bean("data1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate data1SqlSessionTemplate(@Qualifier("data1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
