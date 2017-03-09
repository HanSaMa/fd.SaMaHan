package com.fd.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * <pre>
 * bean工具类。
 * </pre>
 * 
 * @author SaMa.Han guoqiang.han@foxmail.com
 * @version 1.00.00
 * 
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  	修改日期:     修改内容:
 * </pre>
 */
public class BeanUtil {
	
	private BeanUtil(){}
	
	//JavaBean转换为Map  
	public static <T> Map<String,Object> bean2map(Class<T> clz, Object bean) throws Exception{  
	    Map<String,Object> map = new HashMap<>();  
	    //获取指定类的BeanInfo 对象  
	    BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);  
	    //获取所有的属性描述器  
	    PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();  
	    for(PropertyDescriptor pd:pds){  
	        String key = pd.getName();  
	        Method getter = pd.getReadMethod();  
	        Object value = getter.invoke(bean);  
	        map.put(key, value);  
	    }  
	    return map;  
	} 
	
	//Map转换为JavaBean  
	public static <T> T map2bean(Map<String,Object> map,Class<T> clz) throws Exception{  
	    //创建JavaBean对象  
	    T obj = clz.newInstance();  
	    //获取指定类的BeanInfo对象  
	    BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);  
	    //获取所有的属性描述器  
	    PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();  
	    for(PropertyDescriptor pd:pds){  
	        Object value = map.get(pd.getName());  
	        Method setter = pd.getWriteMethod();  
	        setter.invoke(obj, value);  
	    }  
	      
	    return  obj;  
	}  
	
}
