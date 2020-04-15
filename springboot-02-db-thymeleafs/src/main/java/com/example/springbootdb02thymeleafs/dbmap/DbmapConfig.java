package com.example.springbootdb02thymeleafs.dbmap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @CalssName: DbmapConfig
 * @Author: zsx
 * @Date: 2020/4/7 17:23
 **/
@Configuration
public class DbmapConfig {

    @Bean
    public DbmapDialect dbmapDialect(){
        return new DbmapDialect();
    }

}
