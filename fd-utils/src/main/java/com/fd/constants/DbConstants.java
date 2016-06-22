/**
 * 
 */
package com.fd.constants;



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
public class DbConstants {
	
	public static final String PROPERTY_PATH = "/datasource.properties";
	public static final String DRIVER_KEY = "fd.jdbc.driver";
	public static final String URL_KEY = "fd.jdbc.url";
	public static final String USER_NAME_KEY = "fd.jdbc.username";
	public static final String PASSWORD_KEY = "fd.jdbc.password";
	
	// SQLServer
	// 0.7
	// 2000
	public static final String SQL_SERVER_07_OR_2000_DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDviver";
	// SQLServer
	// 2005
	// 2008
	public static final String SQL_SERVER_2005_OR_2008_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// MySQL
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	// Oracle8/8i/9i/10g数据库（thin模式）
	public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	// DB2
	public static final String DB2_DRIVER = "com.ibm.db2.jdbc.app.DB2Driver";
	// Sybase
	public static final String SYSBASE_DRIVER = "com.sybase.jdbc.SybDriver";
	// Informix
	public static final String INFOMIX_DRIVER = "com.informix.jdbc.IfxDriver";
	// PostgreSQL
	public static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
	
}
