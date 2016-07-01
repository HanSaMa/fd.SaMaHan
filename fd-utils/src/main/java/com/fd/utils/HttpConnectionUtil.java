package com.fd.utils;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

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
public class HttpConnectionUtil {
    public static String getHttpContent(String url) {
        return getHttpContent(url, "UTF-8");
    }

    public static String getHttpContent(String url, String charSet) {
        HttpURLConnection connection = null;
        String content = "";
        try {
            URL address_url = new URL(url);
            connection = (HttpURLConnection) address_url.openConnection();
//            connection.setRequestMethod("GET");
            //设置访问超时时间及读取网页流的超市时间,毫秒值
            //JDK1.5之前(含1.5)
            System.setProperty("sun.net.client.defaultConnectTimeout","30000");
            System.setProperty("sun.net.client.defaultReadTimeout", "30000");
            //JDK1.5之后
            connection.setConnectTimeout(100000);
            connection.setReadTimeout(100000);
            //得到访问页面的返回值
            int response_code = connection.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
//                InputStreamReader reader = new InputStreamReader(in,charSet);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, charSet));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    content+=line;
                }
                return content;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection !=null){
                connection.disconnect();
            }
        }
        return "";
    }

    public static void main(String[] args) {
//        String content = HttpConnectionUtil.getHttpContent("http://192.168.1.61:8001/");
        String content = HttpConnectionUtil.getHttpContent("http://localhost:9092/srmmdp-appservice/portal/banks/findBy.ac?pageNo=0&pageSize=20");
        System.out.println("content = " + content);
    }
}