package com.fd.utils.midea;

import java.lang.reflect.Field;

import com.fd.constants.JavaConstants;
import com.fd.constants.X5Constants;

/**
 * 
 * <pre>
 * JAVA 实体转为X5data。
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
public class BeanToX5Util {

	private BeanToX5Util(){}
	
	public static String bean2X5Data(Class<?> clz, String idColumn){
		Field[] fields = clz.getDeclaredFields();
		StringBuffer dataStr = new StringBuffer();
		String clzName = clz.getName().substring(clz.getName().lastIndexOf(".") + 1,clz.getName().lastIndexOf(".") + 2).toLowerCase() + clz.getName().substring(clz.getName().lastIndexOf(".") + 2);
		dataStr.append("<div component=\"$UI/system/components/justep/data/data\" autoLoad=\"true\" xid=\"");
		dataStr.append(clzName).append("Data\" idColumn=\"").append(idColumn).append("\" confirmDelete=\"false\" confirmRefresh=\"false\">\n");
		for (Field field : fields) {
			StringBuffer clmnStr = new StringBuffer();
			clmnStr.append("\t<column label=\"").append("").append("\" name=\"").append(field.getName());
			clmnStr.append("\" type=\"").append(BeanToX5Util.parseJavaTypeToX5Type(field.getType().getName())).append("\"/>\n");
			dataStr.append(clmnStr);
		}
		dataStr.append("</div>\n");
		return dataStr.toString();
	}
	
	public static String parseJavaTypeToX5Type(String javaType){
		String x5Type = X5Constants.STRING;
		switch (javaType) {
		case JavaConstants.LONG:
		case JavaConstants.LONG_TYPE:
		case JavaConstants.BIGINTEGER_TYPE:
			x5Type = X5Constants.LONG;
			break;
		case JavaConstants.SHORT:
		case JavaConstants.SHORT_TYPE:
		case JavaConstants.INTEGER:
		case JavaConstants.INTEGER_TYPE:
			x5Type = X5Constants.INTEGER;
			break;
		case JavaConstants.DOUBLE:
		case JavaConstants.DOUBLE_TYPE:
			x5Type = X5Constants.DOUBLE;
			break;
		case JavaConstants.FLOAT:
		case JavaConstants.FLOAT_TYPE:
			x5Type = X5Constants.FLOAT;
			break;
		case JavaConstants.BIGDECIMAL_TYPE:
			x5Type = X5Constants.DECIMAL;
			break;
		case JavaConstants.DATETIME_TYPE:
			x5Type = X5Constants.DATETIME;
			break;
		case JavaConstants.DATE_TYPE:
			x5Type = X5Constants.DATE;
			break;
		default:
			break;
		}
		return x5Type;
	}
}
