package com.ligaojie.user.entity;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiffUtil {
	
	//查询商品
	public static Object getObjectById(Object target,Long id) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = target.getClass().getDeclaredMethod("findProductById", Long.class);
		Object oldObject = method.invoke(target, id);
		log.info("获取旧值"+oldObject);
		return oldObject;
	}
	
	//插入
	public static List<ChangeItem> getInsertChangeItems(Object obj){
		Map<String, String> beanSimpleFieldValueMap = getBeanSimpleFieldValueMap(obj,true);
		Map<String, String> fieldNameMap = getFieldNameMap(obj);
		
		List<ChangeItem> items = new ArrayList<>();
		for (Map.Entry<String, String> entry : beanSimpleFieldValueMap.entrySet()) {
			String fieldName = entry.getKey();
			String value = entry.getValue();
			ChangeItem item = new ChangeItem();
			item.setOldValue("");
			item.setNewValue(value);
			item.setField(fieldName);
			String cName = fieldNameMap.get(fieldName);
			item.setFieldShowName(cName);
			items.add(item);
		}
		
		return items;
	}

	//获取删除操作的item
	public static ChangeItem getDeleteChangeItem(Object obj) {
		ChangeItem item = new ChangeItem();
		item.setOldValue(JSON.toJSONString(obj));
		item.setNewValue("");
		return item;
	}
	
	//获取更新时 item
	public static List<ChangeItem> getUpdateChangeItem(Object oldObject,Object newObject) {
		Class cl1 = oldObject.getClass();
		List<ChangeItem> changeItems = new ArrayList<ChangeItem>();
		//获取字段中文名称
		Map<String, String> fieldNameMap = getFieldNameMap(oldObject);
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(cl1,Object.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				String field = propertyDescriptor.getName();
				//新旧值比较
				String oldValue = getValue(PropertyUtils.getProperty(oldObject, field));
				String newValue = getValue(PropertyUtils.getProperty(newObject, field));
				if (!oldValue.equals(newObject)) {
					ChangeItem item = new ChangeItem();
					item.setField(field);
					String cName = fieldNameMap.get(field);
					item.setFieldShowName(null != cName? cName:"");
					item.setOldValue(oldValue);
					item.setNewValue(newValue);
					changeItems.add(item);
					
				}
			}
			
			
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	
		return changeItems;
	}
	
	//转字符串处理
	public static String getValue(Object obj){
		
		if (obj !=null) {
			if (obj instanceof Date) {
				return  new Date().toLocaleString();
			} else {
				return obj.toString();
			}
			
		}else {
			return "";
		}
	}
	
	private static Map<String, String> getBeanSimpleFieldValueMap(Object obj, boolean b) {
		Map<String,String> map = new HashMap<String, String>();
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			System.err.println("feeld:"+field.getName());
			String fieldName = field.getName();
		    String fieldValue = null;
			try {
				Object property = PropertyUtils.getProperty(obj, fieldName);
				if (null !=property) {
					fieldValue = property.toString();
				}
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
				
			} catch (NoSuchMethodException e) {
			
			}
		    map.put(fieldName, fieldValue);
		}
		return map;
	}

	//获取所有属性-值
	private static Map<String, String> getFieldNameMap(Object object) {
		Map<String,String> map = new HashMap<String, String>();
		Field[] declaredFields = object.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			System.err.println("feeld:"+field.getName());
			Class<?> type = field.getType();
			String fieldName = field.getName();
		    String fieldValue = null;
			try {
				Object property = PropertyUtils.getProperty(object, fieldName);
				if (null !=property) {
					fieldValue = property.toString();
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    map.put(fieldName, fieldValue);
		}
		return map;
	}
	

}
