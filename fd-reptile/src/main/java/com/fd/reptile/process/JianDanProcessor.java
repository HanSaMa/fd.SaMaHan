package com.fd.reptile.process;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fd.reptile.util.PropertyUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class JianDanProcessor implements PageProcessor {
	
    private static final Log log = LogFactory.getLog(JianDanProcessor.class);

	private Site site = Site.me().setRetryTimes(5).setSleepTime(100);

	public static final String URL_LIST = "/ooxx/page-[\\w]+";

	public static final String savePath = PropertyUtil.getProperty("jiandan.girl.save.path");

	@Override
	public void process(Page page) {
		if (page.getUrl().regex(URL_LIST).match() || page.getUrl().regex("/ooxx").match()) {
			String nextPage = page.getHtml().xpath("//*[@id=\"comments\"]/div[2]/div/a[@class=\"previous-comment-page\"]").links().get();
			
			//图片加密串
			List<String> imgs = page.getHtml().xpath("//*[starts-with(@id, 'comment-')]/div/div/div[2]/p/span/text()").all();
			for (int i = 0; i < imgs.size(); i++) {
				String imgPath = imgs.get(i);
				try {
					String mwPath = new String(Base64.decodeBase64(imgPath), "UTF-8");
					String largePath = mwPath.replace("/mw600/", "/large/");//jpg替换为全图路径
					largePath = largePath.replace("/mw690/", "/large/");//gif

					File saveFile = new File(savePath);
					if(!saveFile.exists()) {
						saveFile.mkdirs();
					}
		            String fileName = largePath.substring(largePath.lastIndexOf("/"));
					
					File file = new File(saveFile + File.separator + fileName);
					if(file.exists()) {
						break;
					}
					log.info("create file : " + fileName);
					
		            URL url = new URL("https:" + largePath);
	                DataInputStream dataInputStream = new DataInputStream(url.openStream());
	     
	                FileOutputStream fileOutputStream = new FileOutputStream(file);
	                ByteArrayOutputStream output = new ByteArrayOutputStream();
	     
	                byte[] buffer = new byte[1024];
	                int length;
	                while ((length = dataInputStream.read(buffer)) > 0) {
	                    output.write(buffer, 0, length);
	                }
	                fileOutputStream.write(output.toByteArray());
	                dataInputStream.close();
	                fileOutputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(null == nextPage) {
				return;
			}
			page.addTargetRequest(nextPage);
		}
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) throws Exception {
		 Spider qsSpider = Spider.create(new
		 JianDanProcessor()).addUrl("https://jandan.net/ooxx")
		 // .addPipeline(new RedisPipeline())
		 // .addPipeline(new JsonFilePipeline())
		 // .addPipeline(new JsonPipeline())
		 .thread(1);
		 qsSpider.start();
	}
}
