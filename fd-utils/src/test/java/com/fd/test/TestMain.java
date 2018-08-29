package com.fd.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
//			TestMain tm = new TestMain();
//			String rootPath = "D:\\GEAM_EAM_V01R04_ECO - 副本";
//			tm.cleanSVNDir(rootPath);
//			Map<String, String> m = new HashMap<String,String>();
//			System.out.println(m.size());
//			m.put("1", "2");
//			System.out.println(m.size());
//			m.put("3", "2");
//			System.out.println(m.size());
//			String sql = "select ca.device_code, r.apply_code from check_asset ca, pay_apply pa, (select check_asset.device_code, pay_apply.apply_code"
//					+ " from check_asset, pay_apply where check_asset.apply_id = pay_apply.apply_id and check_asset.turn_type <> 2 and pay_apply.auditing <> 7"
//					+ " and pay_apply.change_id is null and pay_apply.apply_id != ?) r where ca.apply_id = pa.apply_id and ca.turn_type <> 2 and pa.auditing <> 7 and pa.change_id is null " 
//					+ " and ca.apply_id = ? and ca.device_code = r.device_code";
//			sql += "1";
//			sql = sql + "2";
//			System.out.println(sql);
//			double a = 0.274703D;
//			System.out.println(a*10000);
//			String routeId = "eam1143611";
//			String targetRouteId = "eam0918711";
//			String sql = "'eam84516693','','imp_pay_capital','0',to_date('2017-07-26 14:20:54', 'yyyy-mm-dd hh24:mi:ss'),'insert',to_date('2017-03-08 16:10:56', 'yyyy-mm-dd hh24:mi:ss'),'IU10205941','IU10205941',',import,','','','insert into pay_capital(capital_id,apply_id,out_code,check_code,project_name,\n"
//+"provider_code,provider_name,notax_money,budget_node_desc,budget_node_id)\n"
//+"values({NEWKEYID},{FKEYID},?,?,?,\n"
//+"?,?,?,?,?)','eam1143611','select out_code,check_code,project_name,provider_code,provider_name,l.notax_money,l.budget_node_desc,l.budget_node_id from maint_out_plan h,maint_budget_det l where h.out_plan_id = l.out_plan_id and h.out_plan_id = ?','1','pay_capital'";
//			sql = sql.replaceAll("'" + routeId + "'", "'" + targetRouteId + "'");
//System.out.println(sql);
//			String name = "SVN-变更.docx".substring(0, "SVN-变更.docx".lastIndexOf(".")) + ".pdf";
//			System.out.println(name);
//			System.out.println(!"501".equals("521"));
//			System.out.println("10690203504".substring(0, 6));
//			TestMain t = new TestMain();
//			System.out.println(t.getClass().getName());
//			String a = "/eam_app/IBM/WebSphere/AppServer/profiles/AppSrv01/installedApps/localhostNode01Cell/eamsit1_war.ear/eamsit1.war/files/ex_hangq1/";
//			String [] b = a.split("/");
//			System.out.println(b[b.length - 1]);
			
//			String currency = "CNY";
//			String country = "China";
//			String countryName = "CN";
//			System.out.println(
//					(null != countryName && 0 != countryName.length() && !"中国".equals(countryName)));

//			System.out.println("".equals(null));
//			Date d = new Date(15059602683031956L);
//			System.out.println(d.toString());
			
//			out : for (int i = 0; i < 1000000000; i++) {
//				for (int j = 0; j < 10; j++) {
//					System.out.println(i);
//					if(10 == i){
//						break out;
//					}
//				}
//			}
//			String a = "OU_115801_美的集团电子商务";
//			String a = "";
			List<String> a = new ArrayList<String>();
			List<String> b = new ArrayList<String>();
			a.add("aaa123");
			b.add("aaa123");
			for (String string : b) {
				if(a.contains(string)){
					System.out.println("123");
				}
			}
			System.out.println("end");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	/** 
     * 删除项目中的.svn目录（目录中有文件需要递归删除） 
     * @param dirName  项目路径 
     */  
    public void cleanSVNDir(String rootPath){  
        try{  
            File rootFile = new File(rootPath);  
            if(rootFile.isDirectory()){  
                for(File file : rootFile.listFiles()){  
                    String fileName = file.getName();  
                    if(file.isDirectory() && fileName.equals(".svn")){  
                    	System.out.println("svn file path:" + file.getPath());
                        cleanSVNFile(file.getPath());  
                        file.delete();  
                    }else{  
                        cleanSVNDir(file.getPath());  
                    }  
                }  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 删除SVN目录下的文件 
     * @param svnPath 
     */  
    public void cleanSVNFile(String svnPath){  
        try{  
            File svnFile = new File(svnPath);  
            if(svnFile.isDirectory()){  
                for(File file : svnFile.listFiles()){  
                    if(file.isDirectory()){  
                        /*删除目录下的文件*/  
                        cleanSVNFile(file.getPath());  
                        /*删除目录*/  
                        file.delete();  
                    }else{  
                    	file.delete();  
                    }  
                }  
            }  
        }catch(Exception e){  
            throw new RuntimeException(e);  
        }  
    }  
    

	
	public String getSubmitDir(String rootPath){
		File rootFile = new File(rootPath);
		File[] files = rootFile.listFiles();
		File submitParentFile = null;
		String ym = new SimpleDateFormat("YYYYMM").format(new Date());
		String dd = new SimpleDateFormat("dd").format(new Date());
		for (File file : files) {
			if(file.isDirectory() && -1 != file.getName().indexOf(ym)){
				submitParentFile = file;
				break;
			}
		}
		if(null != submitParentFile){
			String lastModifiedDir = this.getLastModifiedDir(rootPath);
			File lastModifiedFile = new File(rootPath + File.separator + lastModifiedDir);
			if(null == lastModifiedDir || 0 == lastModifiedDir.length()){
				System.out.println("没有找到包含有geam-的目录");
				return null;
			}
			File submitFile = new File(submitParentFile.getPath() + File.separator + dd);
			submitFile.mkdir();
			File submitLastModifiedFile = new File(submitFile.getPath() + File.separator + lastModifiedDir);
			if(!submitLastModifiedFile.exists()){
				submitLastModifiedFile.mkdir();
			}
			this.copyFolder(lastModifiedFile.getPath(), submitLastModifiedFile.getPath());
			
			return submitFile.getPath();
		}
		return null;
	}
	
	
	public String getLastModifiedDir(String parentDirPath){
		File parentFile = new File(parentDirPath);
		File[] files = parentFile.listFiles();
		long lastModified = 0;
		String lastModifiedFileName = "";
		for (File file : files) {
			if(file.isDirectory() && -1 != file.getName().indexOf("geam-") && (0 == lastModified || lastModified < file.lastModified())){
				lastModified = file.lastModified();
				lastModifiedFileName = file.getName();
			}
		}
		return lastModifiedFileName;
	}
	
	public void copyFolder(String oldPath, String newPath) { 
		try { 
			(new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹 
			File a = new File(oldPath); 
			String[] file = a.list(); 
			File temp = null; 
			for (int i = 0; i < file.length; i++) { 
				if(oldPath.endsWith(File.separator)){ 
					temp = new File(oldPath + file[i]); 
				} else{ 
					temp = new File(oldPath + File.separator + file[i]); 
				} 
	
				if(temp.isFile()){ 
					FileInputStream input = new FileInputStream(temp); 
					FileOutputStream output = new FileOutputStream(newPath + File.separator + (temp.getName()).toString()); 
					byte[] b = new byte[1024 * 5]; 
					int len; 
					while ( (len = input.read(b)) != -1) { 
						output.write(b, 0, len); 
					} 
					output.flush(); 
					output.close(); 
					input.close(); 
				} 
				if(temp.isDirectory()){//如果是子文件夹 
					copyFolder(oldPath + File.separator + file[i],newPath + File.separator + file[i]); 
				} 
			} 
		} catch (Exception e) { 
			System.out.println("复制整个文件夹内容操作出错"); 
			e.printStackTrace(); 
		} 
	}
}
