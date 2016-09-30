/**
 * 
 */
package com.fd.utils;

import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;

import com.fd.constants.DbConstants;
import com.fd.constants.JavaConstants;
import com.fd.constants.X5Constants;

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
public class DbUtil {
	private DbUtil(){}
	private static String driver;

	// private static DataSource ds = null;

	private static String url;
	private static String user;
	private static String password;

	static {
		try {
			Properties prop = new Properties();
			InputStream in = DbUtil.class.getResourceAsStream(DbConstants.PROPERTY_PATH);
			prop.load(in);
			driver = prop.getProperty(DbConstants.DRIVER_KEY).trim();
			url = prop.getProperty(DbConstants.URL_KEY).trim();
			user = prop.getProperty(DbConstants.USER_NAME_KEY).trim();
			password = prop.getProperty(DbConstants.PASSWORD_KEY).trim();

			Class.forName(driver);
			// ds = (DataSource)SpringContextUtil.getBean("dataSource");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 建立连接
	 * 
	 * @return con Connection
	 * @throws Exception
	 */
	private static Connection getConnection() throws Exception {
		Connection conn = DriverManager.getConnection(url, user, password);
		// Connection conn = ds.getConnection();
		Driver d = DriverManager.getDriver(conn.getMetaData().getURL());
		driver = d.getClass().getName();
		return conn;
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 * @param stmt
	 * @param preStmt
	 * @param rs
	 * @throws SQLException
	 */
	private static void replease(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}

	/**
	 * 利用正则表达式,获得SELECT SQL中的列名
	 * 
	 * @param sql
	 * @return
	 */
	private static List<String> getColumnsFromSelect(String sql) {
		List<String> colNames = new ArrayList<String>();
		// 取出sql中列名部分
		Pattern p = Pattern.compile("(?i)select\\s(.*?)\\sfrom.*");
		Matcher m = p.matcher(sql.trim());
		String[] tempA = null;
		if (m.matches()) {
			tempA = m.group(1).split(",");
		}
		if (tempA == null) {
			return null;
		}
		String p1 = "(\\w+)";
		String p2 = "(?:\\w+\\s(\\w+))";
		String p3 = "(?:\\w+\\sas\\s(\\w+))";
		String p4 = "(?:\\w+\\.(\\w+))";
		String p5 = "(?:\\w+\\.\\w+\\s(\\w+))";
		String p6 = "(?:\\w+\\.\\w+\\sas\\s(\\w+))";
		String p7 = "(?:.+\\s(\\w+))";
		String p8 = "(?:.+\\sas\\s(\\w+))";
		p = Pattern.compile("(?:" + p1 + "||" + p2 + "||" + p3 + "||" + p4 + "||" + p5 + "||" + p6 + "||" + p7 + "||" + p8 + ")");
		for (String temp : tempA) {
			m = p.matcher(temp.trim());
			if (!m.matches()) {
				continue;
			}
			for (int i = 1; i <= m.groupCount(); i++) {
				if (m.group(i) == null || "".equals(m.group(i))) {
					continue;
				}
				colNames.add(m.group(i));
			}
		}
		return colNames;
	}

	/**
	 * 利用正则表达式,获得INSERT SQL中的列名
	 * 
	 * @param sql
	 * @return
	 */
	private static List<String> getColumnsFromInsert(String sql) {
		List<String> colNames = new ArrayList<String>();
		// 取出sql中列名部分
		Pattern p = Pattern.compile("(?i)insert\\s+into.*\\((.*)\\)\\s+values.*");
		Matcher m = p.matcher(sql.trim());
		String[] tempA = null;
		if (m.matches()) {
			tempA = m.group(1).split(",");
		}
		if (tempA == null) {
			return null;
		}
		String p1 = "(\\w+)";
		String p2 = "(?:\\w+\\s(\\w+))";
		String p3 = "(?:\\w+\\sas\\s(\\w+))";
		String p4 = "(?:\\w+\\.(\\w+))";
		String p5 = "(?:\\w+\\.\\w+\\s(\\w+))";
		String p6 = "(?:\\w+\\.\\w+\\sas\\s(\\w+))";
		String p7 = "(?:.+\\s(\\w+))";
		String p8 = "(?:.+\\sas\\s(\\w+))";
		p = Pattern.compile("(?:" + p1 + "||" + p2 + "||" + p3 + "||" + p4 + "||" + p5 + "||" + p6 + "||" + p7 + "||" + p8 + ")");
		for (String temp : tempA) {
			m = p.matcher(temp.trim());
			if (!m.matches()) {
				continue;
			}
			for (int i = 1; i <= m.groupCount(); i++) {
				if (m.group(i) == null || "".equals(m.group(i))) {
					continue;
				}
				colNames.add(m.group(i));
			}
		}
		return colNames;
	}

	/**
	 * 利用正则表达式,获得UPDATE SQL中的列名, 包括WHERE字句的
	 * 
	 * @param sql
	 * @return
	 */
	private static List<String> getColumnsFromUpdate(String sql) {
		List<String> colNames = new ArrayList<String>();
		// 取出sql中列名部分
		Pattern p = Pattern.compile("(?i)update(?:.*)set(.*)(?:from.*)*where(.*(and)*.*)");
		Matcher m = p.matcher(sql.trim());
		String[] tempA = null;
		if (m.matches()) {
			tempA = m.group(1).split(",");
			if (m.groupCount() > 1) {
				String[] tmp = m.group(2).split("and");
				String[] fina = new String[tempA.length + tmp.length];
				System.arraycopy(tempA, 0, fina, 0, tempA.length);
				System.arraycopy(tmp, 0, fina, tempA.length, tmp.length);
				tempA = fina;
			}
		}
		if (tempA == null) {
			return null;
		}
		String p1 = "(?i)(\\w+)(?:\\s*\\=\\s*.*)";
		String p2 = "(?i)(?:\\w+\\.)(\\w+)(?:\\s*\\=\\s*.*)";
		p = Pattern.compile(p1 + "||" + p2);
		for (String temp : tempA) {
			m = p.matcher(temp.trim());
			if (!m.matches()) {
				continue;
			}
			for (int i = 1; i <= m.groupCount(); i++) {
				if (m.group(i) == null || "".equals(m.group(i))) {
					continue;
				}
				colNames.add(m.group(i));
			}
		}
		return colNames;
	}

	/**
	 * 为sql添加统计代码
	 * 
	 * @param sql
	 * @return
	 */
	private static String addCountSQL(String sql) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select count(*) as dataCount from (");
		sb.append(sql);
		sb.append(") as a");
		return sb.toString();
	}

	/**
	 * 为sql添加分页代码
	 * 
	 * @param sql
	 * @param start
	 * @param limit
	 * @return
	 */
	private static String addPagingSQL(String sql, int start, int limit) {
		StringBuffer sb = new StringBuffer();
		if (DbConstants.SQL_SERVER_07_OR_2000_DRIVER.equals(driver)) {// SQLServer
																			// 0.7
																			// 2000

		} else if (DbConstants.SQL_SERVER_2005_OR_2008_DRIVER.equals(driver)) {// SQLServer
																					// 2005
																					// 2008

		} else if (DbConstants.MYSQL_DRIVER.equals(driver)) {// MySQL
			sb.append(sql);
			sb.append(" LIMIT ");
			sb.append(start);
			sb.append(",");
			sb.append(limit);
		} else if (DbConstants.ORACLE_DRIVER.equals(driver)) {// Oracle8/8i/9i/10g数据库（thin模式）
			List<String> list = getColumnsFromSelect(sql);
			sb.append("select ");
			for (String str : list)
				sb.append(str).append(", ");
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append(" from (").append(sql).append(") as a");
			sb.append(" where rownum between ").append(start == 0 ? 1 : start).append(" and ").append(limit);
		} else if (DbConstants.DB2_DRIVER.equals(driver)) {// DB2

		} else if (DbConstants.SYSBASE_DRIVER.equals(driver)) {// Sybase

		} else if (DbConstants.INFOMIX_DRIVER.equals(driver)) {// Informix

		} else if (DbConstants.POSTGRESQL_DRIVER.equals(driver)) {// PostgreSQL
			sb.append(sql);
			sb.append(" LIMIT ");
			sb.append(limit);
			sb.append(" OFFSET ");
			sb.append(start);
		}
		return sb.toString();
	}

	/**
	 * 将RusultSet对象实例化T对象
	 * 
	 * @param <T>
	 * @param t
	 * @param rs
	 * @param sql
	 * @return t
	 * @throws Exception
	 */
	private static <T> T instance(Class<T> t, ResultSet rs, String sql) throws Exception {
		List<String> columns = getColumnsFromSelect(sql);
		T obj = t.newInstance();
		for (String col : columns) {
			try {
				String columnName = StringUtil.underlineToCamel(col);
				Field f = t.getDeclaredField(columnName);
				f.setAccessible(true);
				Object v = getValue(col, f.getType().getName(), rs);
				f.set(obj, v);
			} catch (NoSuchFieldException e) {
				Field[] fields = t.getDeclaredFields();
				for (Field f : fields) {
					Column column = f.getAnnotation(Column.class);
					if (column != null && column.name().equals(col)) {
						f.setAccessible(true);
						Object v = getValue(col, f.getType().getName(), rs);
						f.set(obj, v);
					}
				}
			}
		}
		return obj;
	}

	private static Object getValue(String columnName, String type, ResultSet rs) throws SQLException {
		Object obj = null;
		if (JavaConstants.INTEGER_TYPE.equals(type) || JavaConstants.INTEGER.equals(type)) {
			obj = rs.getInt(columnName);
		} else if (JavaConstants.LONG_TYPE.equals(type) || JavaConstants.LONG.equals(type)) {
			obj = rs.getLong(columnName);
		} else if (JavaConstants.SHORT_TYPE.equals(type) || JavaConstants.SHORT.equals(type)) {
			obj = rs.getShort(columnName);
		} else if (JavaConstants.FLOAT_TYPE.equals(type) || JavaConstants.FLOAT.equals(type)) {
			obj = rs.getFloat(columnName);
		} else if (JavaConstants.DOUBLE_TYPE.equals(type) || JavaConstants.DOUBLE.equals(type)) {
			obj = rs.getDouble(columnName);
		} else if (JavaConstants.BYTE_TYPE.equals(type) || JavaConstants.BYTE.equals(type)) {
			obj = rs.getByte(columnName);
		} else if (JavaConstants.BOOLEAN_TYPE.equals(type) || JavaConstants.BOOLEAN.equals(type)) {
			obj = rs.getBoolean(columnName);
		} else if (JavaConstants.STRING_TYPE.equals(type)) {
			obj = rs.getString(columnName);
		} else if (JavaConstants.DATE_TYPE.equals(type)) {
			obj = rs.getDate(columnName);
		} else {
			obj = rs.getObject(columnName);
		}
		return obj;
	}

	/**
	 * 将param中的参数添加到pstate
	 * 
	 * @param pstate
	 * @param columns
	 * @throws SQLException
	 */
	private static <T> void setParameters(PreparedStatement pstate, Object... params) throws Exception {
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				Object value = params[i];
				int j = i + 1;
				if (value == null)
					pstate.setString(j, "");
				if (value instanceof String)
					pstate.setString(j, (String) value);
				else if (value instanceof Boolean)
					pstate.setBoolean(j, (Boolean) value);
				else if (value instanceof Date)
					pstate.setDate(j, (Date) value);
				else if (value instanceof Double)
					pstate.setDouble(j, (Double) value);
				else if (value instanceof Float)
					pstate.setFloat(j, (Float) value);
				else if (value instanceof Integer)
					pstate.setInt(j, (Integer) value);
				else if (value instanceof Long)
					pstate.setLong(j, (Long) value);
				else if (value instanceof Short)
					pstate.setShort(j, (Short) value);
				else if (value instanceof Time)
					pstate.setTime(j, (Time) value);
				else if (value instanceof Timestamp)
					pstate.setTimestamp(j, (Timestamp) value);
				else
					pstate.setObject(j, value);
			}
		}
	}

	/**
	 * 将param中的参数添加到pstate
	 * 
	 * @param pstate
	 * @param columns
	 * @param t
	 * @throws SQLException
	 */
	private static <T> void setParameters(PreparedStatement pstate, List<String> columns, T t) throws Exception {
		if (columns != null && columns.size() > 0) {
			for (int i = 0; i < columns.size(); i++) {
				String attr = columns.get(i);
				Object value = null;
				Class<?> c = t.getClass();
				try {
					Field f = c.getDeclaredField(attr);
					value = f.get(t);
				} catch (NoSuchFieldException e) {
					Field[] fields = c.getDeclaredFields();
					for (Field f : fields) {
						Column column = f.getAnnotation(Column.class);
						if (column != null && column.name().equals(attr))
							value = f.get(t);
					}
				}
				int j = i + 1;
				if (value == null)
					pstate.setString(j, "");
				if (value instanceof String)
					pstate.setString(j, (String) value);
				else if (value instanceof Boolean)
					pstate.setBoolean(j, (Boolean) value);
				else if (value instanceof Date)
					pstate.setDate(j, (Date) value);
				else if (value instanceof Double)
					pstate.setDouble(j, (Double) value);
				else if (value instanceof Float)
					pstate.setFloat(j, (Float) value);
				else if (value instanceof Integer)
					pstate.setInt(j, (Integer) value);
				else if (value instanceof Long)
					pstate.setLong(j, (Long) value);
				else if (value instanceof Short)
					pstate.setShort(j, (Short) value);
				else if (value instanceof Time)
					pstate.setTime(j, (Time) value);
				else if (value instanceof Timestamp)
					pstate.setTimestamp(j, (Timestamp) value);
				else
					pstate.setObject(j, value);
			}
		}
	}

	/**
	 * 执行insert操作
	 * 
	 * @param sql
	 *            预编译的sql语句
	 * @param t
	 *            sql中的参数
	 * @return 执行行数
	 * @throws Exception
	 */
	public static <T> int insert(String sql, T t) throws Exception {
		Connection conn = null;
		PreparedStatement pstate = null;
		int updateCount = 0;
		try {
			conn = getConnection();
			List<String> columns = getColumnsFromInsert(sql);
			pstate = conn.prepareStatement(sql);
			setParameters(pstate, columns, t);
			updateCount = pstate.executeUpdate();
		} finally {
			replease(conn, pstate, null);
		}
		return updateCount;
	}

	/**
	 * 执行insert操作
	 * 
	 * @param sql
	 *            预编译的sql语句
	 * @param param
	 *            参数
	 * @return 执行行数
	 * @throws Exception
	 */
	public static <T> int insert(String sql, Object... param) throws Exception {
		Connection conn = null;
		PreparedStatement pstate = null;
		int updateCount = 0;
		try {
			conn = getConnection();
			pstate = conn.prepareStatement(sql);
			setParameters(pstate, param);
			updateCount = pstate.executeUpdate();
		} finally {
			replease(conn, pstate, null);
		}
		return updateCount;
	}

	/**
	 * 执行update操作
	 * 
	 * @param sql
	 *            预编译的sql语句
	 * @param t
	 *            sql中的参数
	 * @return 执行行数
	 * @throws Exception
	 */
	public static <T> int update(String sql, T t) throws Exception {
		Connection conn = null;
		PreparedStatement pstate = null;
		int updateCount = 0;
		try {
			conn = getConnection();
			List<String> columns = getColumnsFromUpdate(sql);
			pstate = conn.prepareStatement(sql);
			setParameters(pstate, columns, t);
			updateCount = pstate.executeUpdate();
		} finally {
			replease(conn, pstate, null);
		}
		return updateCount;
	}

	/**
	 * 执行update操作
	 * 
	 * @param sql
	 * @param param
	 *            参数
	 * @return 执行行数
	 * @throws Exception
	 */
	public static <T> int update(String sql, Object... param) throws Exception {
		Connection conn = null;
		PreparedStatement pstate = null;
		int updateCount = 0;
		try {
			conn = getConnection();
			pstate = conn.prepareStatement(sql);
			setParameters(pstate, param);
			updateCount = pstate.executeUpdate();
		} finally {
			replease(conn, pstate, null);
		}
		return updateCount;
	}

	/**
	 * 查询复数的对象
	 * 
	 * @param t
	 *            查询结果封装的对象类型
	 * @param sql
	 *            预编译的sql
	 * @param param
	 *            查询条件
	 * @return List<T>
	 * @throws Exception
	 */
	public static <T> List<T> queryPlural(Class<T> t, String sql, Object... param) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			setParameters(stmt, param);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(instance(t, rs, sql));
			}
		} finally {
			replease(conn, stmt, rs);
		}
		return list;
	}

	/**
	 * 分页查询复数的对象
	 * 
	 * @param t
	 *            查询结果封装的对象类型
	 * @param start
	 *            开始页
	 * @param limit
	 *            页大小
	 * @param sql
	 *            预编译的sql语句
	 * @param param
	 *            查询参数
	 * @throws Exception
	 */
	public static <T> List<T> queryPluralForPagging(Class<T> t, int start, int limit, String sql, Object... param) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			conn = getConnection();
			// 添加分页代码
			sql = addPagingSQL(sql, start, limit);
			stmt = conn.prepareStatement(sql);
			setParameters(stmt, param);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(instance(t, rs, sql));
			}
		} finally {
			replease(conn, stmt, rs);
		}
		return list;
	}

	/**
	 * 查询单个的对象
	 * 
	 * @param t
	 *            查询结果对象
	 * @param sql
	 *            预编译的sql
	 * @param param
	 *            查询参数
	 * @return T
	 * @throws Exception
	 */
	public static <T> T querySingular(Class<T> t, String sql, Object... param) throws Exception {
		T obj = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstate = null;
		try {
			conn = getConnection();
			pstate = conn.prepareStatement(sql);
			setParameters(pstate, param);
			rs = pstate.executeQuery();
			if (rs.next()) {
				obj = instance(t, rs, sql);
			}
		} finally {
			replease(conn, pstate, rs);
		}
		return obj;
	}

	/**
	 * 查询数据量
	 * 
	 * @param param
	 *            查询参数
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws NamingException
	 */
	public static int queryDataCount(String sql, Object... param) throws Exception {
		int dataCount = 0;
		Connection conn = null;
		PreparedStatement pstate = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			sql = addCountSQL(sql);
			pstate = conn.prepareStatement(sql);
			setParameters(pstate, param);
			rs = pstate.executeQuery();
			if (rs.next()) {
				dataCount = rs.getInt("dataCount");
			}
		} finally {
			replease(conn, pstate, rs);
		}
		return dataCount;
	}

	public static String getQueryTableColumnsSQL(String tableName) throws SQLException {
		StringBuffer sb = new StringBuffer();
		if (DbConstants.SQL_SERVER_07_OR_2000_DRIVER.equals(driver)) {
			
		} else if (DbConstants.SQL_SERVER_2005_OR_2008_DRIVER.equals(driver)) {
//			sb.append(b)
		} else if (DbConstants.MYSQL_DRIVER.equals(driver)) {
			sb.append("select t.column_name, t.data_type, case t.column_key when 'PRI' then true else false end as is_primary, t.column_comment as description ");
			sb.append("from information_schema.columns t where t.table_schema = database()");
			sb.append(" and t.table_name = '").append(tableName).append("'");
		} else if (DbConstants.ORACLE_DRIVER.equals(driver)) {
			
		} else if (DbConstants.DB2_DRIVER.equals(driver)) {
			
		} else if (DbConstants.SYSBASE_DRIVER.equals(driver)) {

		} else if (DbConstants.INFOMIX_DRIVER.equals(driver)) {

		} else if (DbConstants.POSTGRESQL_DRIVER.equals(driver)) {
			
		}
		return sb.toString();
	}
	
	public static String getJavaType(String dataType){
		StringBuffer sb = new StringBuffer();
		if (DbConstants.SQL_SERVER_07_OR_2000_DRIVER.equals(driver)) {
			
		} else if (DbConstants.SQL_SERVER_2005_OR_2008_DRIVER.equals(driver)) {
			
		} else if (DbConstants.MYSQL_DRIVER.equals(driver)) {
			sb.append(getJavaMysqlType(dataType));
		} else if (DbConstants.ORACLE_DRIVER.equals(driver)) {
			
		} else if (DbConstants.DB2_DRIVER.equals(driver)) {
			
		} else if (DbConstants.SYSBASE_DRIVER.equals(driver)) {

		} else if (DbConstants.INFOMIX_DRIVER.equals(driver)) {

		} else if (DbConstants.POSTGRESQL_DRIVER.equals(driver)) {
			
		}
		return sb.toString();
	}
	
	private static String getJavaMysqlType(String dataType){
		switch (dataType) {
			case "VARCHAR":
			case "CHAR":
			case "TEXT":
				return JavaConstants.STRING_TYPE;
			case "BIGINT":
			case "INTEGER":
			case "ID":
				return JavaConstants.LONG_TYPE;
			case "BLOB":
				return JavaConstants.BYTE_ARRAY;
			case "BOOLEAN":
			case "TINYINT":
			case "SMALLINT":
			case "MEDIUMINT":
				return JavaConstants.INTEGER_TYPE;
			case "BIT":
				return JavaConstants.BOOLEAN_TYPE;
			case "FLOAT":
				return JavaConstants.FLOAT_TYPE;
			case "DOUBLE":
				return JavaConstants.DOUBLE_TYPE;
			case "DECIMAL":
				return JavaConstants.BIGDECIMAL_TYPE;
			case "DATE":
			case "TIME":
			case "YEAR":
				return JavaConstants.DATE_TYPE;
			case "DATETIME":
			case "TIMESTAMP":
				return JavaConstants.DATETIME_TYPE;
			default:
				return "";
		}
	}
	
	public static String getX5MysqlType(String dataType){
		dataType = dataType.toUpperCase();
		switch (dataType) {
			case "VARCHAR":
			case "CHAR":
			case "TEXT":
				return X5Constants.STRING;
			case "BIGINT":
			case "INTEGER":
			case "ID":
				return X5Constants.LONG;
			case "BOOLEAN":
			case "TINYINT":
			case "SMALLINT":
			case "MEDIUMINT":
				return X5Constants.INTEGER;
			case "BIT":
				return X5Constants.BOOLEAN;
			case "FLOAT":
				return X5Constants.FLOAT;
			case "DOUBLE":
				return X5Constants.DOUBLE;
			case "DECIMAL":
				return X5Constants.DECIMAL;
			case "DATE":
			case "TIME":
			case "YEAR":
				return X5Constants.DATE;
			case "DATETIME":
			case "TIMESTAMP":
				return X5Constants.DATETIME;
			default:
				return "";
		}
	}
	
	/**
	 * 属性字段的注释，用于标记该属性对应的数据库字段 例如：
	 * 
	 * @Column(name="user_name"); String userName;
	 *                            表示userName这个属性对应的数据库字段是user_name
	 * 
	 *                            如果属性和数据库字段完全一致，则不必标注
	 * @author xueliang
	 */
	@Target({ ElementType.FIELD })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Column {
		String name() default "";
	}

}
