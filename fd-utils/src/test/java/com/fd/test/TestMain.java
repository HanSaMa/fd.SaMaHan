package com.fd.test;
import com.fd.utils.StringUtil;
import com.fd.utils.midea.DbToBeanUtil;
import com.fd.utils.midea.DbToX5Util;
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
//			TableBaseColumnsUtil.addBaseColumn("tsp_bda_vip_users");
			DbToBeanUtil.dbToBean("tsp_bda_vip_users", "com.midea.cdc.basedata.entity");
//			DbToX5Util.printX5Data("tsp_bda_mv_att_file, tsp_bda_mv_att_template, tsp_bda_mv_bc_business, tsp_bda_mv_bc_external, tsp_bda_mv_bc_financial, tsp_bda_mv_bc_history, tsp_bda_mv_bc_honor, tsp_bda_mv_bc_informatization, tsp_bda_mv_bc_investment, tsp_bda_mv_bc_logistics, tsp_bda_mv_bc_logsup, tsp_bda_mv_bc_transportation, tsp_bda_mv_bi_address, tsp_bda_mv_bi_bank, tsp_bda_mv_bi_company, tsp_bda_mv_bi_linkman, tsp_bda_mv_cb_business_info, tsp_bda_mv_cb_holders_info, tsp_bda_mv_cb_relation_info, tsp_bda_mv_cr_check_divice, tsp_bda_mv_cr_equipment, tsp_bda_mv_cr_mold_ability, tsp_bda_mv_cr_pro_equipment, tsp_bda_mv_cr_pro_output, tsp_bda_mv_dd_change_control, tsp_bda_mv_dd_development, tsp_bda_mv_dd_info, tsp_bda_mv_dd_technical_norms, tsp_bda_mv_hr_education, tsp_bda_mv_hr_frontline, tsp_bda_mv_hr_management, tsp_bda_mv_hr_professional, tsp_bda_mv_qa_control, tsp_bda_mv_qa_incoming, tsp_bda_mv_qa_unqualified, tsp_bda_mv_vip_relation");
//			DbToBeanUtil.toElemenStatementt("tsp_bda_mv_att_file, tsp_bda_mv_att_template, tsp_bda_mv_bc_business, tsp_bda_mv_bc_external, tsp_bda_mv_bc_financial, tsp_bda_mv_bc_history, tsp_bda_mv_bc_honor, tsp_bda_mv_bc_informatization, tsp_bda_mv_bc_investment, tsp_bda_mv_bc_logistics, tsp_bda_mv_bc_logsup, tsp_bda_mv_bc_transportation, tsp_bda_mv_bi_address, tsp_bda_mv_bi_bank, tsp_bda_mv_bi_company, tsp_bda_mv_bi_linkman, tsp_bda_mv_cb_business_info, tsp_bda_mv_cb_holders_info, tsp_bda_mv_cb_relation_info, tsp_bda_mv_cr_check_divice, tsp_bda_mv_cr_equipment, tsp_bda_mv_cr_mold_ability, tsp_bda_mv_cr_pro_equipment, tsp_bda_mv_cr_pro_output, tsp_bda_mv_dd_change_control, tsp_bda_mv_dd_development, tsp_bda_mv_dd_info, tsp_bda_mv_dd_technical_norms, tsp_bda_mv_hr_education, tsp_bda_mv_hr_frontline, tsp_bda_mv_hr_management, tsp_bda_mv_hr_professional, tsp_bda_mv_qa_control, tsp_bda_mv_qa_incoming, tsp_bda_mv_qa_unqualified, tsp_bda_mv_vip_relation");
//			DbToX5Util.printX5Grid("tsp_bda_mv_att_file, tsp_bda_mv_att_template, tsp_bda_mv_bc_business, tsp_bda_mv_bc_external, tsp_bda_mv_bc_financial, tsp_bda_mv_bc_history, tsp_bda_mv_bc_honor, tsp_bda_mv_bc_informatization, tsp_bda_mv_bc_investment, tsp_bda_mv_bc_logistics, tsp_bda_mv_bc_logsup, tsp_bda_mv_bc_transportation, tsp_bda_mv_bi_address, tsp_bda_mv_bi_bank, tsp_bda_mv_bi_company, tsp_bda_mv_bi_linkman, tsp_bda_mv_cb_business_info, tsp_bda_mv_cb_holders_info, tsp_bda_mv_cb_relation_info, tsp_bda_mv_cr_check_divice, tsp_bda_mv_cr_equipment, tsp_bda_mv_cr_mold_ability, tsp_bda_mv_cr_pro_equipment, tsp_bda_mv_cr_pro_output, tsp_bda_mv_dd_change_control, tsp_bda_mv_dd_development, tsp_bda_mv_dd_info, tsp_bda_mv_dd_technical_norms, tsp_bda_mv_hr_education, tsp_bda_mv_hr_frontline, tsp_bda_mv_hr_management, tsp_bda_mv_hr_professional, tsp_bda_mv_qa_control, tsp_bda_mv_qa_incoming, tsp_bda_mv_qa_unqualified, tsp_bda_mv_vip_relation");
//			DbToX5Util.pringX5Input("tsp_bda_mv_bc_external");

//			com.fd.utils.DbToBeanUtil.dbToBean("fd_calc_users", "com.fd.calc.entity");
			System.out.println("end");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
