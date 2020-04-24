package com.zsx.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @CalssName: DataSourceConfig
 * @Author: zsx
 * @Date: 2020/4/23 16:54
 **/
@Configuration
@MapperScan(basePackages = "com.zsx.mapper",sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {
    @Primary
    @Bean(name="data1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.data1")
    public DataSource getDataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="data2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.data2")
    public DataSource getDataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("data1DataSource") DataSource dataSource1,
                                        @Qualifier("data2DataSource") DataSource dataSource2){
        Map<Object,Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.DataBaseType.DATA1,dataSource1);
        targetDataSource.put(DataSourceType.DataBaseType.DATA2,dataSource2);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(dataSource1);
        return dataSource;
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/*.xml"));
        return bean.getObject();
    }
}
