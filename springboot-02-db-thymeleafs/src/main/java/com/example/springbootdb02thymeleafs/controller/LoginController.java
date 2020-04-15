package com.example.springbootdb02thymeleafs.controller;


import com.example.springbootdb02thymeleafs.mapper.TbUserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @CalssName: LoginController
 * @Author: zsx
 * @Date: 2020/4/7 16:43
 **/
@Controller
public class LoginController {

    @Resource
    TbUserMapper tbUserMapper;

    @GetMapping("login")
    public String login(){
        return "login";
    }

}
