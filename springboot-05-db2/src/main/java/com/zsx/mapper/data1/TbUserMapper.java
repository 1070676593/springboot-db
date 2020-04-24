package com.zsx.mapper.data1;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsx.entity.TbUser;
import org.springframework.stereotype.Component;

/**
 * @CalssName: TbUserMapper
 * @Author: zsx
 * @Date: 2020/4/7 15:40
 **/
@Component
public interface TbUserMapper extends BaseMapper<TbUser> {
//有问题，等会解决
//    @Select("select * from tb_user where id=#{id}")
//    TbUser selectById(int id);
}
