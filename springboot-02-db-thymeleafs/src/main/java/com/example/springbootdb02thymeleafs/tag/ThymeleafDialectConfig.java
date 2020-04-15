package com.example.springbootdb02thymeleafs.tag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Thymeleaf配置
 * @author lin
 * @date 2019/9/1 13:50
 */
@Configuration
public class ThymeleafDialectConfig {
    @Bean
    public DbMapDialect dbMapDialect() {
        return new DbMapDialect();
    }
}
