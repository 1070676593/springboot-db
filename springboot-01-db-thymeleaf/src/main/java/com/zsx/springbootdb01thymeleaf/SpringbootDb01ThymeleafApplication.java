package com.zsx.springbootdb01thymeleaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.zsx.springbootdb01thymeleaf.mapper"})
@SpringBootApplication
public class SpringbootDb01ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDb01ThymeleafApplication.class, args);
    }

}
