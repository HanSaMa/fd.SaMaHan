package com.fd.utils.midea;

import com.fd.utils.DbUtil;
import com.fd.utils.StringUtil;

/**
 * 
 * <pre>
 * 为数据库表添加其本字段。
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
public class TableBaseColumnsUtil {
	private TableBaseColumnsUtil(){}
	
	public static void addBaseColumn(String tables) throws Exception{
		String[] tablesArr = tables.split(StringUtil.SPLIT);
		
		for (String table : tablesArr) {
			table = table.trim();
			System.out.println(table);
			StringBuffer sql = new StringBuffer("ALTER TABLE `").append(table.toUpperCase()).append("`");
			sql.append(" ADD COLUMN `START_DATE`  date NOT NULL,");
			sql.append(" ADD COLUMN `END_DATE`  date NULL DEFAULT NULL AFTER `START_DATE`,");
			sql.append(" ADD COLUMN `CREATED_BY`  bigint(20) NOT NULL AFTER `END_DATE`,");
			sql.append(" ADD COLUMN `CREATION_DATE`  datetime NOT NULL AFTER `CREATED_BY`,");
			sql.append(" ADD COLUMN `LAST_UPDATED_BY`  bigint(20) NOT NULL AFTER `CREATION_DATE`,");
			sql.append(" ADD COLUMN `LAST_UPDATE_DATE`  datetime NOT NULL AFTER `LAST_UPDATED_BY`,");
			sql.append(" ADD COLUMN `LAST_UPDATE_LOGIN`  bigint(20) NULL DEFAULT '-1' AFTER `LAST_UPDATE_DATE`,");
			sql.append(" ADD COLUMN `ATTRIBUTE_CATEGORY`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `LAST_UPDATE_LOGIN`,");
			for (int i = 0; i < 15; i++) {
				sql.append(" ADD COLUMN `ATTRIBUTE").append(i + 1).append("`  varchar(240),");
			}
			sql.append(" ADD COLUMN `VERSION`  bigint(20) NULL DEFAULT 0,");
			sql.append(" ADD COLUMN `GLOBAL_ID`  bigint(20) NULL,");
			sql.append(" ADD COLUMN `GLOBAL_SID`  varchar(100) NULL,");
			sql.append(" ADD COLUMN `GLOBAL_ORDER`  bigint(20) NULL,");
			sql.append(" ADD COLUMN `OWNER_ID`  varchar(100) NULL,");
			sql.append(" ADD COLUMN `OWNER_SID`  varchar(100) NULL,");
			sql.append(" ADD COLUMN `OWNER_ORDER`  bigint(20) NULL");
			sql.append(" ADD COLUMN `DS_SID`  varchar(100) NULL");
			DbUtil.update(sql.toString());
		}
	}
}
