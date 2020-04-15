package com.example.springbootdb02thymeleafs.tag;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring Context 工具类
 * 
 * @author zhfang
 *
 */
@Component
public class SpringContextUtil implements ApplicationContextAware, InitializingBean {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static <T> T getBean(String name) {
		return (T)applicationContext.getBean(name);
	}
	public static <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}

	public static <T> T getBean(String name, Class<T> requiredType) {
		return applicationContext.getBean(name, requiredType);
	}

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	public static boolean isSingleton(String name) {
		return applicationContext.isSingleton(name);
	}

	public static Class<?> getType(String name) {
		return applicationContext.getType(name);
	}

	/**
	 * 获取Spring上下文
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
 	 * 打印IOC容器中所有的Bean名称
 	 *
 	 * @throws Exception
 	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		/*String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(">>>>>>" + name + ">>>>" + SpringContextUtil.getBean(name));
		}
		System.out.println("------\nBean 总计:" + applicationContext.getBeanDefinitionCount());
		*/
	}

}