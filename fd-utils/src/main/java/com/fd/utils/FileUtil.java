package com.fd.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.filechooser.FileSystemView;
/**
 * 
 * <pre>
 * 。
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
public class FileUtil {
	
	public static final String JAVA_TYPE_FILE = ".java";
	private FileUtil(){}
	
	/**
	 * 在桌面创建文件
	 * @param fileName
	 * @param content
	 * @throws IOException 
	 */
	public static void createFileToDesk(String fileName, String content) throws IOException{
		//当前用户桌面
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
		String desktopPath = desktopDir.getAbsolutePath();
		OutputStream out = new FileOutputStream(new File(desktopPath + System.getProperty("file.separator") + fileName));
		out.write(content.getBytes());
		out.close();
	}
}
