package com.fd.utils.midea;

import com.fd.utils.DbUtil;
import com.fd.utils.StringUtil;

/**
 * 
 * <pre>
 * 数据库基本字段管理。
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
			sql.append(" ADD COLUMN `VERSION`  bigint(20) NULL DEFAULT 0");
			DbUtil.update(sql.toString());
		}
		System.out.println("end");
	}
//	ADD COLUMN `ATTRIBUTE6`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE5`,
//	ADD COLUMN `ATTRIBUTE7`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE6`,
//	ADD COLUMN `ATTRIBUTE8`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE7`,
//	ADD COLUMN `ATTRIBUTE9`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE8`,
//	ADD COLUMN `ATTRIBUTE10`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE9`,
//	ADD COLUMN `ATTRIBUTE11`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE10`,
//	ADD COLUMN `ATTRIBUTE12`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE11`,
//	ADD COLUMN `ATTRIBUTE13`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE12`,
//	ADD COLUMN `ATTRIBUTE14`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE13`,
//	ADD COLUMN `ATTRIBUTE15`  varchar(240) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `ATTRIBUTE14`,
//	ADD COLUMN `VERSION`  bigint(20) NULL DEFAULT 0 AFTER `ATTRIBUTE15`;
}
