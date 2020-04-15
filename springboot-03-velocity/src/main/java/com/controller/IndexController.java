package com.controller;

import com.velocity.VelocityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CalssName: IndexController
 * @Author: zsx
 * @Date: 2020/4/9 14:40
 **/
@Controller
public class IndexController {

    @Autowired
    VelocityUtil velocityUtil;

    @GetMapping("index")
    public String index(Model model){
        velocityUtil.createIdentityInfoVelocity(model);
        velocityUtil.number(model);
        return "index";
    }
}
