/**
 * 
 */
package com.fd.utils;

import java.util.List;
import java.util.Map;


/**
 * 
 * <pre>
 * CSV工具类。
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
public class CsvUtil {
	private CsvUtil(){}
	/** CSV文件列分隔符 */  
    private static final String CSV_COLUMN_SEPARATOR = ",";  
  
    /** CSV文件列分隔符 */  
    private static final String CSV_RN = "\r\n";  
  
    /** 
     *  
     * 将检索数据输出的对应的csv列中 
     * @param data 列头信息
     * @param displayColNames 列头信息
     * @param matchColNames 数据列信息
     * 
     * */  
    public static String formatCsvData(List<Map<String, Object>> data,  
            String displayColNames, String matchColNames) {  
  
        StringBuffer buf = new StringBuffer();  
  
        String[] displayColNamesArr = null;  
        String[] matchColNamesMapArr = null;  
  
        displayColNamesArr = displayColNames.split(",");  
        matchColNamesMapArr = matchColNames.split(",");  
  
        // 输出列头  
        for (int i = 0; i < displayColNamesArr.length; i++) {  
            buf.append(displayColNamesArr[i]).append(CSV_COLUMN_SEPARATOR);  
        }  
        buf.append(CSV_RN);  
  
        if (null != data) {  
            // 输出数据  
            for (int i = 0; i < data.size(); i++) {  
  
                for (int j = 0; j < matchColNamesMapArr.length; j++) {  
                    buf.append(data.get(i).get(matchColNamesMapArr[j])).append(  
                            CSV_COLUMN_SEPARATOR);  
                }  
                buf.append(CSV_RN);  
            }  
        }  
        return buf.toString();  
    }  
    
    /** 
     *  
     * 将检索数据输出的对应的csv列中 
     * @param headInfoList 列头信息
     * @param dataList 数据
     * */  
    public static String formatCsvData(List<Map<String, Object>> headInfoList, List<Map<String, Object>> dataList) {  
        StringBuffer buf = new StringBuffer(); 
  
        for (int i = 0; i < headInfoList.size(); i++) {  

            // 输出列头  
            buf.append(headInfoList.get(i).get("title").toString()).append(CSV_COLUMN_SEPARATOR); 
        }  
        buf.append(CSV_RN);  
  
        if (null != dataList) {  
            // 输出数据  
            for (int i = 0; i < dataList.size(); i++) {  
  
                for (int j = 0; j < headInfoList.size(); j++) {  
                	Object v = dataList.get(i).get(headInfoList.get(j).get("dataKey"));
                    buf.append(null == v ? "" : v.toString().trim()).append(  
                            CSV_COLUMN_SEPARATOR);  
                }  
                buf.append(CSV_RN);  
            }  
        }  
        return buf.toString();  
    }  
    
//    public static void exportCsv(String fileName, String content,  
//            HttpServletResponse response) throws IOException {  
//  
//        // 设置文件后缀  
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhh24mmss");  
//        String fn = fileName.concat(sdf.format(new Date()).toString() + ".csv");  
//  
//        // 读取字符编码  
//        String csvEncoding = "UTF-8";  
//  
//        // 设置响应  
//        response.setCharacterEncoding(csvEncoding);  
//        response.setContentType("text/csv; charset=" + csvEncoding);  
//        response.setHeader("Pragma", "public");  
//        response.setHeader("Cache-Control", "max-age=30");  
//        response.setHeader("Content-Disposition", "attachment; filename="  
//                + new String(fn.getBytes(), csvEncoding));  
//  
//        // 写出响应  
//        OutputStream os = response.getOutputStream();  
//        os.write(content.getBytes("GBK"));  
//        os.flush();  
//        os.close();  
//    }  
  
}
