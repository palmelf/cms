package com.ajun.spring.orm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.ibatis.executor.resultset.DynamicBeanWrapper;

import com.shishuo.cms.entity.Article;
import com.shishuo.cms.util.JacksonUtil;

public class CglibTest {
	public static final String beanJson = "{\"articleId\":0,\"firstFolderId\":0,\"secondFolderId\":0,\"thirdFolderId\":0,\"fourthFolderId\":0,\"adminId\":0,\"ename\":null,\"name\":\"454dddddddddddddddddddddd\",\"title\":null,\"content\":null,\"description\":null,\"price\":null,\"realPrice\":null,\"copyCount\":0,\"viewCount\":0,\"commentCount\":0,\"status\":null,\"owner\":null,\"createTime\":null,\"updateTime\":null,\"expireTime\":null,\"address\":\"789reeeeeeeeeeeeeeeeeeeeee\",\"id\":123,\"address$Desc\":\"address$Descaddress$Descaddress$Desc\"}";

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// 设置类成员属性
		HashMap<String, Class<?>> propertyMap = new HashMap<>();
		propertyMap.put("id", Integer.class);
		propertyMap.put("name", String.class);
		propertyMap.put("address", String.class);
		propertyMap.put("address$Desc", String.class);
		// 生成动态 Bean
		DynamicBeanWrapper bean = new DynamicBeanWrapper(Article.class, propertyMap);
		// 给 Bean 设置值
		// bean.setValue("id", new Integer(123));
		// bean.setValue("name", "454dddddddddddddddddddddd");
		// bean.setValue("address", "789reeeeeeeeeeeeeeeeeeeeee");
		// bean.setValue("address$Desc","address$Descac");
		// 获得bean的实体
		Object object = bean.getObject();
		System.err.println("========================");
		// 通过反射查看所有方法名
		Class<?> clazz = object.getClass();
		Object jsonObject = JacksonUtil.json2Bean(beanJson, clazz);
		System.err.println("========jsonObject================" + jsonObject);
		String json = JacksonUtil.bean2Json(object);
		System.err.println("========================" + json);
		System.err.println("========================" + clazz);
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();
			if (methodName.equals("setAddress$Desc")) {
				method.setAccessible(true);
				method.invoke(object, "dddddddddddddddddddddddddddddddddddddddddddddd");
			}
			System.out.println(methods[i].getName());
		}
		json = JacksonUtil.bean2Json(object);
		System.err.println("========================" + json);
	}
}
