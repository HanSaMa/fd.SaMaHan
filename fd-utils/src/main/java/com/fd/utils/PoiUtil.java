/**
 * 
 */
package com.fd.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * 
 * <pre>
 * EXCEL工具类(目前只有导出)。
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
public class PoiUtil {
	private PoiUtil(){}

    /**
     * 1.创建 workbook
     * @return
     */
    public HSSFWorkbook getHSSFWorkbook(){
        return new HSSFWorkbook();
    }

    /**
     * 2.创建 sheet
     * @param hssfWorkbook
     * @param sheetName sheet 名称
     * @return
     */
    public HSSFSheet getHSSFSheet(HSSFWorkbook hssfWorkbook, String sheetName){
        return hssfWorkbook.createSheet(sheetName);
    }

    /**
     * 3.写入表头信息
     * @param hssfWorkbook
     * @param hssfSheet
     * @param headInfoList List<Map<String, Object>>
     *              key: title         列标题
     *                   width   列宽
     *                   dataKey       列对应的 dataList item key
     */
    public void writeHeader(HSSFWorkbook hssfWorkbook,HSSFSheet hssfSheet ,List<Map<String, Object>> headInfoList){
        HSSFCellStyle cs = hssfWorkbook.createCellStyle();
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short)12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        cs.setFont(font);
        cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFRow r = hssfSheet.createRow(0);
        r.setHeight((short) 380);
        HSSFCell c = null;
        Map<String, Object> headInfo = null;
        //处理excel表头
        for(int i=0, len = headInfoList.size(); i < len; i++){
            headInfo = headInfoList.get(i);
            c = r.createCell(i);
            c.setCellValue(headInfo.get("title").toString());
            c.setCellStyle(cs);
            if(headInfo.containsKey("width")){
                hssfSheet.setColumnWidth(i, (short)((Integer.parseInt(headInfo.get("width").toString()) * 8) / ((double) 1 / 20)));
            }
        }
    }

    /**
     * 4.写入内容部分
     * @param hssfWorkbook
     * @param hssfSheet
     * @param startIndex 从1开始，多次调用需要加上前一次的dataList.size()
     * @param headInfoList List<Map<String, Object>>
     *              key: title         列标题
     *                   columnWidth   列宽
     *                   dataKey       列对应的 dataList item key
     * @param dataList
     * @param pattern 日期格式化参数  默认：yyyy-MM-dd
     */
    public void writeContent(HSSFWorkbook hssfWorkbook,HSSFSheet hssfSheet ,int startIndex,
                                     List<Map<String, Object>> headInfoList, List<Map<String, Object>> dataList){
        Map<String, Object> headInfo = null;
        HSSFRow r = null;
        HSSFCell c = null;
        //处理数据
        Map<String, Object> dataItem = null;
        Object v = null;
        if(65536 < dataList.size()){
        	r = hssfSheet.createRow(0);
        	c = r.createCell(0);
        	c.setCellValue("数据量太大 ，请分批次导出");
        	return;
        }
        for (int i=0, rownum = startIndex, len = (startIndex + dataList.size()); rownum < len; i++,rownum++){
            r = hssfSheet.createRow(rownum);
            r.setHeightInPoints(16);
            dataItem = dataList.get(i);
            for(int j=0, jlen = headInfoList.size(); j < jlen; j++){
                headInfo = headInfoList.get(j);
                c = r.createCell(j);
                v = dataItem.get(headInfo.get("dataKey").toString());
                if (v instanceof String) {
                    c.setCellValue((String)v);
                }else if (v instanceof Boolean) {
                    c.setCellValue((Boolean)v);
                }else if (v instanceof Calendar) {
                    c.setCellValue((Calendar)v);
                }else if (v instanceof Double) {
                    c.setCellValue((Double)v);
                }else if (v instanceof Integer
                        || v instanceof Long
                        || v instanceof Short
                        || v instanceof Float) {
                    c.setCellValue(Double.parseDouble(v.toString()));
                }else if (v instanceof HSSFRichTextString) {
                    c.setCellValue((HSSFRichTextString)v);
                }else{
                    c.setCellValue(null == v ? "" : v.toString());
                }
            }
        }
    }

    public void write2FilePath(HSSFWorkbook hssfWorkbook, String filePath) throws IOException{
        FileOutputStream fileOut = null;
        try{
            fileOut = new FileOutputStream(filePath);
            hssfWorkbook.write(fileOut);
        }finally{
            if(fileOut != null){
                fileOut.close();
            }
        }
    }
    
    public void write(HSSFWorkbook hssfWorkbook, OutputStream out) throws IOException{
        try{
            hssfWorkbook.write(out);
        }finally{
            if(out != null){
            	out.close();
            }
        }
    }


    /**
     * 导出excel
     * @param sheetName   sheet名称
     * @param out I/O设备
     * @param headInfoList List<Map<String, Object>>
     *                           key: title         列标题
     *                                width   列宽
     *                                dataKey       列对应的 dataList item key
     * @param dataList  List<Map<String, Object>> 导出的数据
     * @throws java.io.IOException
     *
     */
    public static void exportExcel(String sheetName, OutputStream out,
                                   List<Map<String, Object>> headInfoList,
                                   List<Map<String, Object>> dataList) throws IOException {
        PoiUtil poiUtil = new PoiUtil();
        //1.创建 Workbook
        HSSFWorkbook hssfWorkbook = poiUtil.getHSSFWorkbook();
        //2.创建 Sheet
        HSSFSheet hssfSheet = poiUtil.getHSSFSheet(hssfWorkbook, sheetName);
        //3.写入 head
        poiUtil.writeHeader(hssfWorkbook, hssfSheet, headInfoList);
        //4.写入内容
        poiUtil.writeContent(hssfWorkbook, hssfSheet, 1, headInfoList, dataList);
        //5.输出文件
        poiUtil.write(hssfWorkbook, out);
    }
    
	public static void createTemplate(String sheetName, OutputStream out, List<Map<String, Object>> headInfoList, List<Map<String, Object>> dataList) throws IOException {
		PoiUtil poiUtil = new PoiUtil();
		// 1.创建 Workbook
		HSSFWorkbook hssfWorkbook = poiUtil.getHSSFWorkbook();		
		// 2.创建 Sheet
		HSSFSheet hssfSheet = poiUtil.getHSSFSheet(hssfWorkbook, sheetName);
		// 3.写入 head
		poiUtil.writeHeader(hssfWorkbook, hssfSheet, headInfoList);
		// 4.写入内容
		poiUtil.writeContent(hssfWorkbook, hssfSheet, 1, headInfoList, dataList);
		
		// 5.创建设定
		HSSFSheet settingSheet = poiUtil.getHSSFSheet(hssfWorkbook, "TemplateSetting");
		poiUtil.writeSetting(hssfWorkbook, settingSheet, headInfoList);
		// 6.输出文件
		poiUtil.write(hssfWorkbook, out);
	}   
    
    
    /**
     * @param fs
     * @return
     * @throws IOException
     */
    public HSSFWorkbook getHSSFWorkbook(POIFSFileSystem fs) throws IOException{
        return new HSSFWorkbook(fs);
    }
    
    /**
     * 创建 POIFSFileSystem
     * @param ins
     * @return
     * @throws IOException
     */
    public POIFSFileSystem getPOIFSFileSystem(InputStream ins) throws IOException{
    	return new POIFSFileSystem(ins);
    }    

    public void writeSetting(HSSFWorkbook hssfWorkbook,HSSFSheet hssfSheet ,List<Map<String, Object>> headInfoList){
        HSSFCellStyle cs = hssfWorkbook.createCellStyle();
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short)12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        cs.setFont(font);
        cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFRow r = hssfSheet.createRow(0);
        r.setHeight((short) 380);
        HSSFCell c = null;
        Map<String, Object> headInfo = null;
        //处理excel表头
        for(int i=0, len = headInfoList.size(); i < len; i++){
            headInfo = headInfoList.get(i);
            c = r.createCell(i);
            c.setCellValue(headInfo.get("dataKey").toString());
            c.setCellStyle(cs);
            if(headInfo.containsKey("width")){
                hssfSheet.setColumnWidth(i, (short)((Integer.parseInt(headInfo.get("width").toString()) * 8) / ((double) 1 / 20)));
            }
        }
    }    
    
}
