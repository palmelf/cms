package org.apache.ibatis.executor.resultset;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

public class DynamicBeanWrapper {

	/**
	 * 实体Object
	 */
	private Object object = null;

	/**
	 * 属性map
	 */
	private BeanMap beanMap = null;

	public DynamicBeanWrapper() {
		super();
	}

	/**
	 * 给指定的class添加运行时的属性
	 * 
	 * @param superClass
	 *            被增强的类，不能被final修饰
	 * @param propertyMap
	 *            要添加的属性
	 */
	public DynamicBeanWrapper(Class<?> superClass, Map<String, Class<?>> propertyMap) {
		this.object = generateBean(superClass, propertyMap);
		this.beanMap = BeanMap.create(this.object);
	}

	/**
	 * 给bean属性赋值
	 * 
	 * @param property
	 *            属性名
	 * @param value
	 *            值
	 */
	public void setValue(String property, Object value) {
		beanMap.put(property, value);
	}

	/**
	 * 通过属性名得到属性值
	 * 
	 * @param property
	 *            属性名
	 * @return 值
	 */
	public Object getValue(String property) {
		return beanMap.get(property);
	}

	/**
	 * 得到该实体bean对象
	 * 
	 * @return
	 */
	public Object getObject() {
		return this.object;
	}

	/**
	 * @param propertyMap
	 * @param superclass
	 * @return
	 */
	private Object generateBean(Class<?> superclass, Map<String, Class<?>> propertyMap) {
		BeanGenerator generator = new BeanGenerator();
		generator.setSuperclass(superclass);
		Set<String> keySet = propertyMap.keySet();
		for (Iterator<String> i = keySet.iterator(); i.hasNext();) {
			String key = i.next();
			generator.addProperty(key, propertyMap.get(key));
		}
		return generator.create();
	}

}
