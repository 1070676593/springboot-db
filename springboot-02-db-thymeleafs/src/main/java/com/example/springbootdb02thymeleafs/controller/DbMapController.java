/**
 * Copyright (C), 2018-2019, 张芳
 */
package com.example.springbootdb02thymeleafs.controller;


import com.example.springbootdb02thymeleafs.service.DbMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CalssName: DbMapController
 * @Descrption:
 * @Author: zhfang
 * @Date: 2019/9/25 15:29
 **/
@RestController
@RequestMapping("/dbmap")
public class DbMapController {

    @Autowired
    DbMapService dbMapService;

    @GetMapping("/refresh/{account}")
    public String refresh(@PathVariable("account")String account){
        if ("zhfang".equals(account)){
            boolean refresh = dbMapService.refresh();
            if (refresh){
                return "缓存刷新成功";
            }
            return "缓存刷新失败";
        }
        return "资源不存在";
    }



    @GetMapping("/version")
    public String version() {
        String version = "2020-04-03 17:30";
        System.out.println(version);
        return version;
    }
}
