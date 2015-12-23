package com.shishuo.cms.mybatis;

import java.util.List;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class BeanWrapperObjectFactory extends DefaultObjectFactory {
	private static final long serialVersionUID = 773797745506645842L;

	@Override
	public <T> T create(Class<T> type) {
		return super.create(type);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes,
			List<Object> constructorArgs) {
		return super.create(type, constructorArgTypes, constructorArgs);
	}

}