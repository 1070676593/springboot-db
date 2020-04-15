package com.example.springbootdb02thymeleafs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.springbootdb02thymeleafs.mapper")
@SpringBootApplication
public class SpringbootDb02ThymeleafsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDb02ThymeleafsApplication.class, args);
    }

}
