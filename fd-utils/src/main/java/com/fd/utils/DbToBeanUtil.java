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
public class DbToBeanUtil {
	private DbToBeanUtil(){}
	
	public static void dbToBean(String tables, String packageStr) throws Exception{
		String[] tableArr = tables.toLowerCase().split(StringUtil.SPLIT);
		for (String table : tableArr) {
			table = table.trim();
			String className = StringUtil.underlineToCamel(table);
			className = className.substring(0, 1).toUpperCase() + className.substring(1);
			String sql = DbUtil.getQueryTableColumnsSQL(table.toUpperCase());
			List<TableColumns> columns = DbUtil.queryPlural(TableColumns.class, sql);
			
			StringBuffer main = new StringBuffer("package ").append(packageStr).append(";\n\n");
			main.append("import java.io.Serializable;\n");
			main.append("import javax.persistence.Id;\n");
			main.append("import javax.persistence.Entity;\n");
			main.append("import javax.persistence.Table;\n");
			main.append("import javax.persistence.GeneratedValue;\n");
			main.append("import javax.persistence.Column;\n");
			main.append("\n/**\n *\n * <pre>\n * .\n * </pre>\n *\n * @autor SaMa.Han guoqiang.han@foxmail.com\n");
			main.append(" * @version 1.00.00\n *\n * <pre>\n * 修改记录\n * \t修改后版本：\t修改人：\t修改日期：\t修改内容： \n");
			main.append(" * </pre>\n */\n@Entity\n@Table(name=\"").append(table.toUpperCase()).append("\")\n");
			main.append("public class ").append(className).append(" implements Serializable {\n");
			main.append("\tprivate static final long serialVersionUID = ").append(new Date().getTime()).append("L;\n\n");
			
			StringBuffer method = new StringBuffer();
			StringBuffer toString = new StringBuffer("\t@Override\n\tpublic String toString(){\n\t\treturn \"");
			toString.append(className).append("[");
			for (TableColumns column : columns) {
				String columnName = StringUtil.underlineToCamel(column.getColumnName().toLowerCase());
				String dataType = DbUtil.getJavaType(column.getDataType().toUpperCase());
				//字段属性并添加注解
				if(column.getIsPrimary()){
					main.append("\t@Id\n");
					main.append("\t@GeneratedValue(strategy=GenerationType.AUTO)\n");
				}
				main.append("\t@Column(name=\"").append(column.getColumnName().toUpperCase()).append("\")\n");
				main.append("\tprivate ").append(dataType).append(" ").append(columnName).append(";");
				main.append("//").append(column.getDescription()).append("\n");
				
				//getter/setter方法
				String firstLetter = columnName.substring(0, 1).toUpperCase();
				method.append("\tpublic ").append(dataType).append(" get").append(firstLetter).append(columnName.substring(1)).append("(){\n");
				method.append("\t\treturn this.").append(columnName).append(";\n\t}\n");
				method.append("\tpublic void set").append(firstLetter).append(columnName.substring(1)).append("(");
				method.append(dataType).append(" ").append(columnName).append("){\n");
				method.append("\t\tthis.").append(columnName).append(" = ").append(columnName).append(";\n\t}\n");
				
				toString.append(columnName).append("=\" + ").append("this.").append(columnName).append(" + \",");
			}
			main.append("\n");
			method.append("\n");
			toString = new StringBuffer(toString.substring(0, toString.length() - 1));
			toString.append("]\";\n\t}\n");
			main.append(method).append(toString).append("}");
			
			FileUtil.createFileToDesk(className + FileUtil.JAVA_TYPE_FILE, main.toString());
		}
	}
}
