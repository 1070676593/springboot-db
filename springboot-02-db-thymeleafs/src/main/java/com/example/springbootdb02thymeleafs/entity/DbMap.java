package com.example.springbootdb02thymeleafs.entity;

import lombok.Data;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class DbMap implements Serializable {
	private static final long serialVersionUID = 7150812560511020660L;
	private String example;
	private String key;
	private String value;
	private Date updateDate;
	private String remark;
	private String isCache; // 是否支持内存缓存  0：默认不支持  1：支持
	private Long expireDate; // 到期时间
	private Integer seq; // 排序字段

	public DbMap() {
		// 缓存到期时间，当前时间的两个小时后
		this(2 * 60 * 60 * 1000);
	}

	public DbMap(int time) {
		this.expireDate = System.currentTimeMillis() + time + (long)((Math.random()*9+1)*1000);
	}

	public DbMap(String example, String key, String value) {
		this.example = example;
		this.key = key;
		this.value = value;
		this.expireDate = System.currentTimeMillis() + 2 * 60 * 60 * 1000 + (long)((Math.random()*9+1)*1000);
	}

	public DbMap deepClone() {
		try {
			// 将对象写到流里
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(this);
			// 从流里读出来
			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			return (DbMap) oi.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			// 失败的时候，直接创建一个对象，正常的克隆对象不是这么处理的。不过这个对象比较简单
			DbMap dbMap = new DbMap();
			dbMap.setExample(this.example);
			dbMap.setKey(this.key);
			dbMap.setValue(this.value);
			dbMap.setIsCache("0");
			dbMap.setSeq(this.seq);
			return dbMap;
		}
	}

	/**
	 * 返回惟一标识
	 * @return
	 */
	public String getOnlyKye() {
		return this.example + "." + this.key;
	}

	/**
	 * 转成Map
	 * @return
	 */
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<>();
		map.put("EXAMPLE", example);
		map.put("KEY", key);
		map.put("VALUE", value);
		return map;
	}

	/**
	 * 判断当前数据是否到期
	 * @return true:到期
	 */
	public boolean isExpire() {
		return System.currentTimeMillis() > this.expireDate;
	}

	public Integer getSeq() {
		return seq == null ? 0 : seq;
	}

}
