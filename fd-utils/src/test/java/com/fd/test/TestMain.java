package com.fd.test;
import com.fd.utils.midea.DbToBeanUtil;
import com.fd.utils.midea.TableBaseColumnsUtil;

/**
 * 
 */

/**
 * 
 * <pre>
 * 测试类。
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
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			System.out.println("begin");
			DbToBeanUtil.dbToBean("TSP_MD_MV_VIP_RELATION", "com.midea.srm.system.entity");
			System.out.println("end");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}