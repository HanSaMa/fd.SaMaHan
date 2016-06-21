package com.fd.utils;

import java.util.Date;
import java.util.List;

import com.fd.entity.TableColumns;

/**
 * 
 * <pre>
 * 数据库连接工具类。
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
public class DbToBeanUtil implements java.io.Serializable {
	public static void dbToBean(String tables, String packageStr) throws Exception{
		String[] tableArr = StringUtil.split(tables, StringUtil.SPLIT_CHAR);
		for (String table : tableArr) {
			String className = StringUtil.underlineToCamel(table);
			String sql = DbUtil.getQueryTableColumnsSQL(table);
			List<TableColumns> columns = DbUtil.queryPlural(TableColumns.class, sql);
			
			StringBuffer main = new StringBuffer("package ").append(packageStr).append(";\n\n");
			main.append("import java.io.Serializable;\n");
			main.append("\n/**\n *\n * <pre>\n * .\n * </pre>\n *\n * @autor SaMa.Han guoqiang.han@foxmail.com\n");
			main.append(" * @version 1.00.00\n *\n * <pre>\n * 修改记录\n * \t修改后版本：\t修改人：\t修改日期：\t修改内容： \n");
			main.append(" * </pre>\n */\npublic class ").append(className).append(" implements Serializable {\n");
			main.append("\tprivate static final long serialVersionUID = ").append(new Date().getTime()).append("L;\n\n");
			for (TableColumns column : columns) {
				String columnName = StringUtil.underlineToCamel(column.getColumnName());
				String dataType = column.getDataType();
				main.append("\tprivate ").append(dataType);
			}
			main.append("}");
		}
	}
}
