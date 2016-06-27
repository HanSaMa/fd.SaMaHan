package com.fd.utils.midea;

import java.util.List;

import com.fd.entity.TableColumns;
import com.fd.utils.DbUtil;
import com.fd.utils.StringUtil;

/**
 * 
 * <pre>
 * 数据库表转换为X5的DATA组件声明工具类。
 * </pre>
 * 
 * @author SaMa.Han guoqiang.han@foxmail.com
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  	修改日期:     修改内容:
 * </pre>
 */
public class DbToX5DataUtil {
	private DbToX5DataUtil() {
	}

	public static void printX5Data(String tables) throws Exception {
		String[] tablesArr = tables.split(StringUtil.SPLIT);

		for (String table : tablesArr) {
			table = table.trim();
			System.out.println(table);
			StringBuffer main = new StringBuffer();
			StringBuffer clmns = new StringBuffer();
			String propertyName = StringUtil.underlineToCamel(table);
			main.append("<div component=\"$UI/system/components/justep/data/data\" autoLoad=\"true\" xid=\"");
			main.append(propertyName).append("Data\" idColumn=\"");
			String sql = DbUtil.getQueryTableColumnsSQL(table.toUpperCase());
			List<TableColumns> columns = DbUtil.queryPlural(TableColumns.class, sql);
			
			for (TableColumns column : columns) {
				String columnName = StringUtil.underlineToCamel(column.getColumnName().toLowerCase());
				if(column.getIsPrimary()){
					main.append(columnName).append("\">\n");
				}
				String columnType = DbUtil.getX5MysqlType(column.getDataType());
				clmns.append("\t<column lable=\"").append(column.getDescription()).append("\" name=\"").append(columnName);
				clmns.append("\" type=\"").append(columnType).append("\"/>\n");
			}
			main.append(clmns);
			main.append("</div>\n");
			main.append("<!------------------------------------------------>\n");
			System.out.println(main.toString());
		}
	}

}
