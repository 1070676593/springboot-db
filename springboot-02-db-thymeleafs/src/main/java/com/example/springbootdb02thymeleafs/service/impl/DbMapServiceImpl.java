package com.example.springbootdb02thymeleafs.service.impl;


import com.example.springbootdb02thymeleafs.entity.DbMap;
import com.example.springbootdb02thymeleafs.mapper.DbMapMapper;
import com.example.springbootdb02thymeleafs.service.DbMapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class DbMapServiceImpl implements DbMapService {
	@Resource
	private DbMapMapper dbMapMapper;
	private final static String DEF = "default";
	
	private static HashMap<String, DbMap> map = new HashMap<>();
	
	private static HashMap<String, Integer> countMap = new HashMap<>();
	
	private static final String NOT_VALUE = "not value";

	/************************判断区*************************/
	@Override
	public boolean exists(String key) {
		return exists(key, DEF);
	}

	@Override
	public boolean exists(String key, String example) {
		DbMap dbMap = this.getBean(key, example);
//		return map.get(example + "." + key) != null ? true : dbMapDao.exists(key, example);
		return !NOT_VALUE.equals(dbMap.getRemark());
	}

	@Override
	public boolean has(String key, String str) {
		return has(key, DEF, str);
	}

	@Override
	public boolean has(String key, String example, String str) {
		if(str == null || str.length() == 0) {
			return false;
		}
		return indexOf(key, example, str) > -1;
	}

	@Override
	public int indexOf(String key, String str) {
		return indexOf(key, DEF, str);
	}

	@Override
	public int indexOf(String key, String example, String str) {
		if(str == null) {
			return -1;
		}
		return get(key, example).indexOf(str);
	}
	
	@Override
	public String[] split(String key) {
		return split(key, DEF, ";", 0);
	}
	
	@Override
	public String[] split(String key, String example) {
		return split(key, example, ";", 0);
	}
	
	@Override
	public String[] split(String key, String example, String regex) {
		return split(key, example, regex, 0);
	}
	
	@Override
	public String[] split(String key, String example, int limit) {
		return split(key, example, ";", limit);
	}
	
	@Override
	public String[] split(String key, String example, String regex, int limit) {
		String value = get(key, example);
		return value.split(regex, limit);
	}
	
	/************************修改区*************************/
	@Override
	public boolean put(String key, String value) {
		return put(key, value, DEF);
	}

	@Override
	public boolean put(String key, String value, String example) {
//		Map<String, String> params = new HashMap<>();
//		params.put("key", key);
//		params.put("value", value);
//		params.put("example", example);
//		dbMapDao.putProc(params);
		DbMap dbMap = new DbMap(example, key, value);
		boolean flag;
		if(this.exists(key, example)) {
			flag = dbMapMapper.put(dbMap);
		} else {
			dbMapMapper.insert(dbMap);
			flag = true;
		}
		// 如果操作成功，则更新缓存
		if(flag) {
			DbMap dm = map.get(key);
			if(dm != null) {
				dm.setValue(value);
			} else {
				dbMap.setIsCache("1");
				map.put(dbMap.getOnlyKye(), dbMap);
			}
		}
		return flag;
	}

	@Override
	public boolean putSync(String key, String value, String oldValue) {
		return putSync(key, oldValue, DEF, oldValue);
	}

	@Override
	public boolean putSync(String key, String value, String example, String oldValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean plus(String key) {
		return plus(key, 1, DEF);
	}

	@Override
	public boolean plus(String key, int num) {
		return plus(key, num, DEF);
	}

	@Override
	public boolean plus(String key, String example) {
		return plus(key, 1, example);
	}

	@Override
	public boolean plus(String key, int num, String example) {
		if(this.exists(key, example)) {
			return dbMapMapper.operation(new DbMap(example, key, num + ""));
		} else {
			dbMapMapper.insert(new DbMap(example, key, num + ""));
			return true;
		}
	}

	@Override
	public boolean reduce(String key) {
		return reduce(key, 1, DEF);
	}

	@Override
	public boolean reduce(String key, int num) {
		return reduce(key, num, DEF);
	}

	@Override
	public boolean reduce(String key, String example) {
		return reduce(key, 1, example);
	}

	@Override
	public boolean reduce(String key, int num, String example) {
		return plus(key, -num, example);
	}

	/************************删除区*************************/
	@Override
	public boolean remove(String key) {
		return remove(key, DEF);
	}

	@Override
	public boolean remove(String key, String example) {
		return dbMapMapper.remove(new DbMap(example, key, ""));
	}
	
	/************************查询区*************************/
	@Override
	public List<DbMap> getAllBean() {
		return getAllBean(new DbMap());
	}

	@Override
	public List<DbMap> getAllBean(DbMap dbMap) {
		return dbMapMapper.getAllBean(dbMap);
	}

	@Override
	public String get(String key) {
		return get(key, DEF);
	}

	@Override
	public String get(String key, String example) {
		DbMap dbMap = getBean(key, example);
		return dbMap == null ? "" : dbMap.getValue();
	}

	@Override
	public String get(String key, String example, String... param) {
		DbMap dbMap = getBean(key, example);
		String val = dbMap == null ? "" : dbMap.getValue();
		for(int a = 0; a < param.length; a++) {
			String str = param[a] == null ? "" : param[a];
			val = val.replaceAll("\\{" + a + "\\}", str);
		}
		return val;
	}

	@Override
	public DbMap getBean(String key) {
		return getBean(key, DEF);
	}

	@Override
	public DbMap getBean(String key, String example) {
		// 先从map里取数据，如果不为空则返回，如果为空的话再从数据库里查出来
		DbMap dbMap = map.get(example + "." + key);
		if(dbMap != null && !dbMap.isExpire()) {
			return dbMap;
		}
		List<DbMap> list = dbMapMapper.getBean(new DbMap(example, key, ""));
		if(list.size() > 0) {
			dbMap = list.get(0);
		} else {
			// 如果数据库里查不到这个值的话，则创建一个空值，减小数据库压力
			dbMap = new DbMap(60 * 60 * 1000); // 创建一个60分钟的缓存
			dbMap.setExample(example);
			dbMap.setKey(key);
			dbMap.setValue("");
			dbMap.setRemark(NOT_VALUE);
			dbMap.setIsCache("1");
		}
		String onlyKey = dbMap.getOnlyKye();
		if("1".equals(dbMap.getIsCache())) {
			map.put(onlyKey, dbMap); // 放缓存里面
		}
		Integer c = countMap.get(onlyKey);
		c = c == null ? 1 : (c + 1);
		countMap.put(onlyKey, c);
		return dbMap;
	}

	@Override
	public DbMap getBean(String key, String example, String... param) {
		DbMap dbMap = getBean(key, example).deepClone();
		dbMap.setValue(this.get(key, example, param));
		return dbMap;
	}

	@Override
	public List<DbMap> getExample() {
		return getExample(DEF);
	}

	@Override
	public List<DbMap> getExample(String example) {
		return getExample(example, false);
	}

	@Override
	public List<DbMap> getExample(String example, boolean falg) {
		if(falg) {
			return dbMapMapper.getExample(new DbMap(example, "", ""));
		} else {
			List<DbMap> list = new ArrayList<>(20);
			Set<String> set = map.keySet();
			for(String key : set) {
				String ex = map.get(key).getExample();
				if(ex == null) {
					continue;
				}
				if(ex.equals(example)) {
					list.add(map.get(key));
				}
			}
			return list;
		}
	}
	
	/************************功能区*************************/
	@Override
	public boolean refresh() {
		try {
			DbMap param = new DbMap();
			// 查询所有配置缓存的东西
			param.setIsCache("1");
			List<DbMap> list = dbMapMapper.getAllBean(param);
//			map = new HashMap<String, DbMap>();
			map.clear(); // 清楚所有缓存
			for(DbMap dbMap : list) {
				// 如果数据库里配置的是可以支持缓存的话才加载到map里面
//				if("1".equals(dbMap.getIsCache())) {
				map.put(dbMap.getOnlyKye(), dbMap);
//				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Map<String, Integer> getCountMap() {
		return countMap;
	}

}
