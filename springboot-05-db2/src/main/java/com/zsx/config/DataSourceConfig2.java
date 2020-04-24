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

/**
 * @CalssName: DataSourceConfig2
 * @Author: zsx
 * @Date: 2020/4/23 23:37
 **/
@Configuration
@MapperScan(basePackages = "com.zsx.mapper.data2",sqlSessionFactoryRef = "data2SqlSessionFactory")
public class DataSourceConfig2 {
    @Bean("data2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.data2")
    public DataSource getDataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Bean("data2SqlSessionFactory")
    public SqlSessionFactory data2SqlSessionFactory(@Qualifier("data2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                //设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/data2/*.xml")
        );
        return bean.getObject();
    }

    @Bean("data2SqlSessionTemplate")
    public SqlSessionTemplate data2SqlSessionTemplate(@Qualifier("data2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
