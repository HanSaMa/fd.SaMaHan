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
public class DbToX5Util {
	private DbToX5Util() {
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
					main.append(columnName).append("\" confirmDelete=\"false\" confirmRefresh=\"false\">\n");
				}
				String columnType = DbUtil.getX5MysqlType(column.getDataType());
				clmns.append("\t<column label=\"").append(column.getDescription()).append("\" name=\"").append(columnName);
				clmns.append("\" type=\"").append(columnType).append("\"/>\n");
			}
			main.append(clmns);
			main.append("</div>\n");
			main.append("<!------------------------------------------------>\n");
			System.out.println(main.toString());
		}
	}
	
	public static void printX5Grid(String tables) throws Exception {
		String[] tablesArr = tables.split(StringUtil.SPLIT);

		for (String table : tablesArr) {
			table = table.trim();
			System.out.println(table);
			StringBuffer main = new StringBuffer();
			String propertyName = StringUtil.underlineToCamel(table);
			main.append("<div component=\"$UI/system/components/justep/grid/grid\" hiddenCaptionbar=\"true\"");
			main.append(" altRows=\"true\" class=\"x-grid-no-bordered\" data=\"").append(propertyName).append("Data\"");
			main.append(" xid=\"").append(propertyName).append("Gd\" height=\"auto\"> \n\t<columns>\n");

			String sql = DbUtil.getQueryTableColumnsSQL(table.toUpperCase());
			List<TableColumns> columns = DbUtil.queryPlural(TableColumns.class, sql);
			
			for (TableColumns column : columns) {
				String columnName = StringUtil.underlineToCamel(column.getColumnName().toLowerCase());
				
				if(null != column.getDescription() && !column.getDescription().isEmpty()){
					main.append("\t\t<column name=\"").append(columnName).append("\"/>\n");
				}
			}
			main.append("\t\t<column name=\"delClmn\" label=\"删除\"/>\n");
			main.append("\t</columns>\n</div>\n");
			main.append("<!------------------------------------------------>\n");
			System.out.println(main.toString());
		}
	}
	
	public static void pringX5Input(String tables) throws Exception {
		String[] tablesArr = tables.split(StringUtil.SPLIT);
		for (String table : tablesArr) {
			table = table.trim();
			System.out.println(table);
			StringBuffer main = new StringBuffer();
			String propertyName = StringUtil.underlineToCamel(table);
			String sql = DbUtil.getQueryTableColumnsSQL(table.toUpperCase());
			List<TableColumns> columns = DbUtil.queryPlural(TableColumns.class, sql);
			for (TableColumns column : columns) {
				String columnName = StringUtil.underlineToCamel(column.getColumnName().toLowerCase());
				
				if(null != column.getDescription() && !column.getDescription().isEmpty()){
					main.append("<div component=\"$UI/system/components/justep/row/row\" class=\"x-row\"  xid=\"").append(propertyName).append("Data-").append(columnName).append("\">\n");
					main.append("\t<div class=\"x-col x-col-20\"/>\n");
					main.append("\t<div class=\"x-col x-col-20 x-col-bottom\">\n");
					main.append("\t\t<label class=\"pull-right\">\n");
					main.append("\t\t\t<span class=\"cred\"></span><![CDATA[").append(column.getDescription()).append("：]]> \n");
					main.append("\t\t</label>\n\t</div>\n\t<div class=\"x-col x-col-20\">\n\t\t<input component=\"$UI/system/components/justep/input/input\" class=\"form-control input-sm\"");
					main.append(" data=\"").append(propertyName).append("Data\" ");
					main.append(" placeHolder=\"\" bind-ref='$model.").append(propertyName).append("Data.ref(\"").append(columnName).append("\")' xid=\"");
					main.append(columnName).append("\"/> ");
					main.append("\n\t</div> \n\t<div class=\"x-col\"/>\n </div>\n\n");
				}
			}
			main.append("<!------------------------------------------------>\n");
			System.out.println(main.toString());
		}
	}
}
