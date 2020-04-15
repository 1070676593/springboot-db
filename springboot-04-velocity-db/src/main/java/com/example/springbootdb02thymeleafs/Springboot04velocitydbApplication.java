package com.example.springbootdb02thymeleafs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.springbootdb02thymeleafs.mapper")
@SpringBootApplication
public class Springboot04velocitydbApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04velocitydbApplication.class, args);
    }

}
