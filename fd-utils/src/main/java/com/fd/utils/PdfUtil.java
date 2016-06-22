/**
 * 
 */
package com.fd.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * 
 * <pre>
 * 导出PDF工具类。
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
public class PdfUtil {
	private PdfUtil(){}
	
	/**
	 * 
	 * @param title 表格标题
	 * @param headInfoList 表格列头
	 * @param dataList 表格数据
	 * @param out
	 * @throws IOException 
	 */
	public static void exportPdf(String title, List<Map<String, Object>> headInfoList,List<Map<String, Object>> dataList, OutputStream out, Map<String, Object> exportParams) throws IOException{
		// step 1
	    Rectangle r = new Rectangle(PageSize.A4);
	    if(null !=  exportParams && null != exportParams.get("paperType")){
	    	if(null == exportParams.get("orientation")){
	    		r = getRectangle(exportParams.get("paperType").toString());
	    	}else{
	    		r = getRectangle(exportParams.get("paperType").toString(), exportParams.get("orientation").toString());
	    	}
	    }
	    Document document = new Document(r);
	    // step 2
	    try {
	      PdfWriter.getInstance(document, out);
	 
	      document.addTitle(title);
	      document.addAuthor("SaMa.Han");
//	      document.addSubject("This is the subject of the PDF file.");
//	      document.addKeywords("This is the keyword of the PDF file.");
	 
	      // step 3
	      document.open();
	      // step 4
//	      PdfPTable table = createTable1();
//	      document.add(table);
//	       
//	      table = createTable2();
//	      table.setSpacingBefore(5);
//	      table.setSpacingAfter(5);
//	      document.add(table);
//	       
//	      table = createTable3();
//	      document.add(table);
//	       
//	      table = createTable4();
//	      table.setSpacingBefore(5);
//	      table.setSpacingAfter(5);
//	      document.add(table);
//	       
//	      table = createTable5();
//	      document.add(table);
	       
	      PdfPTable table = createTable6(title, headInfoList, dataList);
	      document.add(table);
	 
	    } catch (DocumentException e) {
	      e.printStackTrace();
	    } finally {
	      // step 5
	      document.close();
	    }
	}
	
	 /**
	   * Creates a table; widths are set with setWidths().
	   * 
	   * @return a PdfPTable
	   * @throws DocumentException
	   */
	  public static PdfPTable createTable1() throws DocumentException {
	    PdfPTable table = new PdfPTable(3);
	    table.setWidthPercentage(288 / 5.23f);
	    table.setWidths(new int[] { 2, 1, 1 });
	     
	    PdfPCell cell;
	    cell = new PdfPCell(new Phrase("Table 1"));
	    cell.setColspan(3);
	    table.addCell(cell);
	     
	    cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
	    cell.setRowspan(2);
	    table.addCell(cell);
	    table.addCell("row 1; cell 1");
	    table.addCell("row 1; cell 2");
	    table.addCell("row 2; cell 1");
	    table.addCell("row 2; cell 2");
	    return table;
	  }
	 
	  /**
	   * Creates a table; widths are set with setWidths().
	   * 
	   * @return a PdfPTable
	   * @throws DocumentException
	   */
	  public static PdfPTable createTable2() throws DocumentException {
	    PdfPTable table = new PdfPTable(3);
	    table.setTotalWidth(288);
	    table.setLockedWidth(true);
	    table.setWidths(new float[] { 2, 1, 1 });
	    PdfPCell cell;
	    cell = new PdfPCell(new Phrase("Table 2"));
	    cell.setColspan(3);
	    table.addCell(cell);
	    cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
	    cell.setRowspan(2);
	    table.addCell(cell);
	    table.addCell("row 1; cell 1");
	    table.addCell("row 1; cell 2");
	    table.addCell("row 2; cell 1");
	    table.addCell("row 2; cell 2");
	    return table;
	  }
	 
	  /**
	   * Creates a table; widths are set in the constructor.
	   * 
	   * @return a PdfPTable
	   * @throws DocumentException
	   */
	  public static PdfPTable createTable3() throws DocumentException {
	    PdfPTable table = new PdfPTable(new float[] { 2, 1, 1 });
	    table.setWidthPercentage(55.067f);
	    PdfPCell cell;
	    cell = new PdfPCell(new Phrase("Table 3"));
	    cell.setColspan(3);
	    table.addCell(cell);
	    cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
	    cell.setRowspan(2);
	    table.addCell(cell);
	    table.addCell("row 1; cell 1");
	    table.addCell("row 1; cell 2");
	    table.addCell("row 2; cell 1");
	    table.addCell("row 2; cell 2");
	    return table;
	  }
	 
	  /**
	   * Creates a table; widths are set with special setWidthPercentage() method.
	   * 
	   * @return a PdfPTable
	   * @throws DocumentException
	   */
	  public static PdfPTable createTable4() throws DocumentException {
	    PdfPTable table = new PdfPTable(3);
	    Rectangle rect = new Rectangle(523, 770);
	    table.setWidthPercentage(new float[] { 144, 72, 72 }, rect);
	    PdfPCell cell;
	    cell = new PdfPCell(new Phrase("Table 4"));
	    cell.setColspan(3);
	    table.addCell(cell);
	    cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
	    cell.setRowspan(2);
	    table.addCell(cell);
	    table.addCell("row 1; cell 1");
	    table.addCell("row 1; cell 2");
	    table.addCell("row 2; cell 1");
	    table.addCell("row 2; cell 2");
	    return table;
	  }
	 
	  /**
	   * Creates a table; widths are set with setTotalWidth().
	   * 
	   * @return a PdfPTable
	   * @throws DocumentException
	   */
	  public static PdfPTable createTable5() throws DocumentException {
	    PdfPTable table = new PdfPTable(3);
	    table.setTotalWidth(new float[] { 144, 72, 72 });
	    table.setLockedWidth(true);
	    PdfPCell cell;
	    cell = new PdfPCell(new Phrase("Table 5"));
	    cell.setColspan(3);
	    table.addCell(cell);
	    cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
	    cell.setRowspan(2);
	    table.addCell(cell);
	    table.addCell("row 1; cell 1");
	    table.addCell("row 1; cell 2");
	    table.addCell("row 2; cell 1");
	    table.addCell("row 2; cell 2");
	    return table;
	  }
	   
	  public static PdfPTable createTable6(String title, List<Map<String, Object>> headInfoList,List<Map<String, Object>> dataList) throws DocumentException, IOException{
	    PdfPTable table = new PdfPTable(headInfoList.size());
	    table.setWidthPercentage(100);//设置表格宽度100%
//	    table.setTotalWidth(595);
	    //table.setLockedWidth(true);
	     
	    Font fontChinese = PdfUtil.getChineseFont(12F);
	      
	    PdfPCell cell;
	    cell = new PdfPCell(new Phrase(title, fontChinese));//标题
	    cell.setColspan(headInfoList.size());
	    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    table.addCell(cell);
	    
	    for (int i = 0; i < headInfoList.size(); i++) {//列头信息
			cell = new PdfPCell(new Phrase(String.valueOf(headInfoList.get(i).get("title")), fontChinese));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
		}
	    if (null != dataList) {  
            // 输出数据  
            for (int i = 0; i < dataList.size(); i++) {  
                for (int j = 0; j < headInfoList.size(); j++) {  
                	Object v = dataList.get(i).get(headInfoList.get(j).get("dataKey"));
                	cell = new PdfPCell(new Phrase(String.valueOf(null == v ? "" : v), fontChinese));
        			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        			table.addCell(cell);
                }  
            }  
        }  
	     
	    return table;
	  }
	   
	public static Rectangle getRectangle(String pageSize) {
		if("A1".equals(pageSize)){return PageSize.A1;}
		if("A2".equals(pageSize)){return PageSize.A2;}
		if("A3".equals(pageSize)){return PageSize.A3;}
		if("A4".equals(pageSize)){return PageSize.A4;}
		if("A5".equals(pageSize)){return PageSize.A5;}
		if("A6".equals(pageSize)){return PageSize.A6;}
		if("A7".equals(pageSize)){return PageSize.A7;}
		if("A8".equals(pageSize)){return PageSize.A8;}
		if("A9".equals(pageSize)){return PageSize.A9;}
		if("A10".equals(pageSize)){return PageSize.A10;}
		return PageSize.A4;
	}
	
	public static Rectangle getRectangle(String pageSize, String orientation) {
		Rectangle r = getRectangle(pageSize);
		if(null != orientation && "横向".equals(orientation)){
			r = r.rotate();
		}
		return r;
	}
	
	public static Font getChineseFont(Float fontSize) throws DocumentException, IOException{
		/** 
         * 新建一个字体,iText的方法 STSongStd-Light 是字体，在iTextAsian.jar 中以property为后缀 
         * UniGB-UCS2-H 是编码，在iTextAsian.jar 中以cmap为后缀 H 代表文字版式是 横版， 相应的 V 
         * 代表竖版 
         */  
	    BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	    Font fontChinese = new Font(baseFontChinese, fontSize, Font.NORMAL);
	    return fontChinese;
	}
	
	
	public static PdfPCell getPdfPCell(String content, Font fontChinese){
		return new PdfPCell(new Phrase(content, fontChinese));
	}
	
	public static PdfPCell getPdfPCell(String content, Font fontChinese, Integer hAlign, BaseColor backGroundColor, Integer border){
		PdfPCell cell = PdfUtil.getPdfPCell(content, fontChinese);
		cell.setHorizontalAlignment(hAlign);
		if(null != backGroundColor){
			cell.setBackgroundColor(backGroundColor);
		}
		if(null != border){
			cell.setBorder(border);
		}
		return cell;
	}
}
