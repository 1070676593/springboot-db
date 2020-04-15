package com.velocity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class Velocity_AutoConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(Velocity_AutoConfig.class);
	
	@Resource
	Velocity velocity;
	
	/**
	 * 系统配置信息读取
	 * 
	 * 
	 */
	@PostConstruct
	public void autoInIt() {
		logger.info("Velocity_AutoConfig autoInit");
		try {
			velocity.setIdentityInfo(new VelocityTemplate("velocity/identityInfo.vm"));
			velocity.setNumber(new VelocityTemplate("velocity/number.vm"));
		} catch (Exception e) {
			logger.error("Velocity_AutoConfig 加载Velocity模版出错了");
			e.printStackTrace();
		}
	}

}
