package com.seawaterbt.ssm.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.seawaterbt.ssm.annotation.DataSource;
import com.seawaterbt.ssm.entity.Teacher;
import com.seawaterbt.ssm.enums.DataSourceEnum;
import com.seawaterbt.ssm.mapper.TeacherMapper;
import com.seawaterbt.ssm.service.TeacherService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@DataSource(DataSourceEnum.DB2)
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper,Teacher> implements TeacherService {

    @Override
    
    public boolean insert(Teacher entity) {
        return super.insert(entity);
    }

    @Override
    
    public boolean deleteById(Serializable id) {
        return super.deleteById(id);
    }

    @Override
    
    public boolean updateById(Teacher entity) {
        return super.updateById(entity);
    }

    @Override
    
    public Teacher selectById(Serializable id) {
        return super.selectById(id);
    }

    @Override
    
    public List<Teacher> selectList(Wrapper<Teacher> wrapper) {
        return super.selectList(wrapper);
    }

    @Override
    
    public Page<Teacher> selectPage(Page<Teacher> page) {
        return super.selectPage(page);
    }

    @Override
    
    public Page<Teacher> selectPage(Page<Teacher> page, Wrapper<Teacher> wrapper) {
        return super.selectPage(page, wrapper);
    }
}
