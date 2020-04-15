package com.example.springbootdb02thymeleafs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdb02thymeleafs.entity.TbUser;
import com.example.springbootdb02thymeleafs.mapper.TbUserMapper;
import com.example.springbootdb02thymeleafs.service.TbUserService;
import org.springframework.stereotype.Service;

/**
 * @CalssName: TbUserServiceImpl
 * @Author: zsx
 * @Date: 2020/4/15 15:48
 **/
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {
}
