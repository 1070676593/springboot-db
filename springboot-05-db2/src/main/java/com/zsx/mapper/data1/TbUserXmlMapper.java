package com.zsx.mapper.data1;




import com.zsx.entity.TbUser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @CalssName: TbUserXmlMapper
 * @Author: zsx
 * @Date: 2020/4/7 15:54
 **/
@Component
public interface TbUserXmlMapper {

    TbUser getBillByBid(int id);

    List<TbUser> selectAll();
}
