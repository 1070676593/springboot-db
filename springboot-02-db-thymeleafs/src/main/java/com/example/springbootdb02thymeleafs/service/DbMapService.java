package com.example.springbootdb02thymeleafs.service;


import com.example.springbootdb02thymeleafs.entity.DbMap;

import java.util.List;
import java.util.Map;

/**
 * dbMap
 * @author lin
 * @date 2019/7/21 0:54
 */
public interface DbMapService {
	//------------------判断区------------------
	/**
	 * 判断一个key是否存在
	 * @param key 键，对应表中的key字段
	 * @return 是否存在
	 */
	boolean exists(String key);
	/**
	 * 判断一个example下的key是否存在
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @return 是否存在
	 */
	boolean exists(String key, String example);
	
	/**
	 * 判断key里的值是否包含str
	 * @param key 键，对应表中的key字段
	 * @param str 要查找的字符串
	 * @return 查找到对应字段串的下标
	 */
	int indexOf(String key, String str);
	
	/**
	 * 判断key里的值是否包含str
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @param str 要查找的字符串
	 * @return 查找到对应字段串的下标
	 */
	int indexOf(String key, String example, String str);
	
	/**
	 * 判断key里面是否包含str
	 * @param key 键，对应表中的key字段
	 * @param str 要查找的字符串
	 * @return 是否存在对应的字符串
	 */
	boolean has(String key, String str);
	
	/**
	 * 判断example里的key里面是否包含str
	 * @param key 键，对应表中的key字段
	 * @param str 要查找的字符串
	 * @return 是否存在对应的字符串
	 */
	boolean has(String key, String example, String str);
	
	/**
	 * 根据一个key分割字符串，根据";"分割
	 * @param key 键，对应表中的key字段
	 * @return 分割后的数组
	 */
	String[] split(String key);
	
	/**
	 * 根据一个key分割字符串，根据";"分割
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @return 分割后的数组
	 */
	String[] split(String key, String example);
	
	/**
	 * 根据一个key和example分割字符串，根据regex分割
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @param regex 分割的正则
	 * @return 分割后的数组
	 */
	String[] split(String key, String example, String regex);
	
	/**
	 * 根据一个key和example分割字符串，根据";"分割
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @param limit 自己猜
	 * @return 分割后的数组
	 */
	String[] split(String key, String example, int limit);
	
	/**
	 * 根据一个key和example分割字符串，根据regex分割
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @param regex 分割的正则
	 * @param limit 自己猜
	 * @return 分割后的数组
	 */
	String[] split(String key, String example, String regex, int limit);
	
	//------------------修改区------------------
	/**
	 * 根据一个key修改对应的值
	 * @param key 键，对应表中的key字段
	 * @param value 需要更新的值
	 * @return 是否更新成功
	 */
	boolean put(String key, String value);
	
	/**
	 * 根据一个key修改example对应的值
	 * @param key 键，对应表中的key字段
	 * @param value 需要更新的值
	 * @param example 实例，对应表中的example字段
	 * @return 是否更新成功
	 */
	boolean put(String key, String value, String example);
	/**
	 * 根据一个key修改对应的值
	 * @param key 键，对应表中的key字段
	 * @param value 需要更新的值
	 * @param oldValue
	 * @return 是否更新成功
	 */
	boolean putSync(String key, String value, String oldValue);
	
	/**
	 * 根据一个key修改example对应的值
	 * @param key 键，对应表中的key字段
	 * @param value 需要更新的值
	 * @param example 实例，对应表中的example字段
	 * @param oldValue
	 * @return 是否更新成功
	 */
	boolean putSync(String key, String value, String example, String oldValue);
	
	/**
	 * 根据key把值加1
	 * @param key 键，对应表中的key字段
	 * @return 是否更新成功
	 */
	boolean plus(String key);
	
	/**
	 * 根据key把值加num
	 * @param key 键，对应表中的key字段
	 * @param num 要增加的值
	 * @return 是否更新成功
	 */
	boolean plus(String key, int num);
	
	/**
	 * 根据key把example对应的值加1
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @return 是否更新成功
	 */
	boolean plus(String key, String example);
	
	/**
	 * 根据key把example对应的值加num
	 * @param key 键，对应表中的key字段
	 * @param num 要增加的值
	 * @param example 实例，对应表中的example字段
	 * @return 是否更新成功
	 */
	boolean plus(String key, int num, String example);
	
	/**
	 * 根据key把值减1
	 * @param key 键，对应表中的key字段
	 * @return 是否更新成功
	 */
	boolean reduce(String key);
	
	/**
	 * 根据key把值减num
	 * @param key 键，对应表中的key字段
	 * @param num 减去的值
	 * @return 是否更新成功
	 */
	boolean reduce(String key, int num);
	
	/**
	 * 根据key把example对应的值减1
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @return 是否更新成功
	 */
	boolean reduce(String key, String example);
	
	/**
	 * 根据key把example对应的值减num
	 * @param key 键，对应表中的key字段
	 * @param num 要减的值
	 * @param example 实例，对应表中的example字段
	 * @return 是否更新成功
	 */
	boolean reduce(String key, int num, String example);
	
	
	//------------------删除区------------------
	/**
	 * 根据一个key删除对应的值
	 * @param key 键，对应表中的key字段
	 * @return 是否删除成功
	 */
	boolean remove(String key);
	
	/**
	 * 根据一个key删除example对应的值
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @return 是否删除成功
	 */
	boolean remove(String key, String example);
	
	
	//------------------查询区------------------
	/**
	 * 查询全部
	 * @return 全部结果
	 */
	List<DbMap> getAllBean();
	
	List<DbMap> getAllBean(DbMap dbMap);
	/**
	 * 根据一个key获取对应的值
	 * @param key 键，对应表中的key字段
	 * @return 对应的值
	 */
	String get(String key);
	
	/**
	 * 根据一个key获取example对应的值<br />
	 * <span style="color: red;">第三个以上的参数可以替换对应{0}, {1}, {2}的值</span>
	 *
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @return 对应的值
	 */
	String get(String key, String example);
	
	/**
	 * 根据一个key获取example对应的值，并替换内容
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @param str 数组，替换{0}, {1}, {2}
	 * @return 对应的值
	 */
	String get(String key, String example, String... str);

	/**
	 * 获取默认的实例，默认key为default
	 * @return 所有bean
	 */
	List<DbMap> getExample();
	
	/**
	 * 获取指定的实例
	 * @param example 实例，对应表中的example字段
	 * @return 所有bean
	 */
	List<DbMap> getExample(String example);
	
	/**
	 * 获取指定的实例
	 * @param example 实例，对应表中的example字段
	 * @param falg 是否从数据库查询
	 * @return 所有bean
	 */
	List<DbMap> getExample(String example, boolean falg);
	
	/**
	 * 获取DbMap对象数据
	 * @param key 键，对应表中的key字段
	 * @return 对应的bean
	 */
	DbMap getBean(String key);
	
	/**
	 * 获取DbMap对象数据
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @return 对应的bean
	 */
	DbMap getBean(String key, String example);
	
	/**
	 * 根据一个key获取example对应的值，并替换内容
	 * @param key 键，对应表中的key字段
	 * @param example 实例，对应表中的example字段
	 * @param str 数组，替换{0}, {1}, {2}
	 * @return 对应的bean
	 */
	DbMap getBean(String key, String example, String... str);
	
	
	//------------------功能区------------------
	/**
	 * 刷新缓存数据
	 * @return 是否刷新成功
	 */
	boolean refresh();
	
	/**
	 * 获取map记录调用次数统计
	 * @return 各个键的会用次数
	 */
	Map<String, Integer> getCountMap();
}
