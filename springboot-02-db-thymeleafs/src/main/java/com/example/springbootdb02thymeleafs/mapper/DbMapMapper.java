package com.example.springbootdb02thymeleafs.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdb02thymeleafs.entity.DbMap;

import java.util.List;

public interface DbMapMapper extends BaseMapper<DbMap> {

	boolean put(DbMap dbMap);

	List<DbMap> getBean(DbMap dbMap);

	boolean remove(DbMap dbMap);

	boolean operation(DbMap dbMap);

	boolean exists(DbMap dbMap);

	List<DbMap> getExample(DbMap dbMap);
	/**
	 * 获取所有dbMap里的所有Bean
	 * @return List<DbMap>
	 */
	List<DbMap> getAllBean(DbMap dbMap);

}
