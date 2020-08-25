package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

/**
 * @CalssName: LoginController
 * @Author: zsx
 * @Date: 2020/8/13 09:42
 **/

@RestController
public class LoginController {

    @ApiOperation(value="获取用户信息",tags={"获取用户信息copy"},notes="注意问题点")
    @GetMapping("login")
    public String login(@ApiParam(name="name",value="用户name",required=true) String name){
        return JSONObject.toJSONString("123465");
    }
}
