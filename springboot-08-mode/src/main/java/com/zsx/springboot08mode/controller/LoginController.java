package com.zsx.springboot08mode.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @CalssName: LoginController
 * @Author: zsx
 * @Date: 2020/4/20 14:28
 **/
@RestController
public class LoginController {

    org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("login")
    public String login(){
        log.info("111111111111111111");
        log.info("222222222222222222");
        return "132456789";
    }
}
