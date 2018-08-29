package com.fd.reptile.process;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class TMProcessor implements PageProcessor {
	
    private static final Log log = LogFactory.getLog(TMProcessor.class);

	private Site site = Site.me().setRetryTimes(5).setSleepTime(100);

	@Override
	public void process(Page page) {
		if (page.getUrl().toString().contains("search_product")) {
			List<String> nextPages = page.getHtml().xpath("//*[@class=\"productShop-name\"]").links().all();
			for (String nextPage : nextPages) {
				System.out.println(nextPage);
				page.addTargetRequest(nextPage);
			}
		}else if(page.getUrl().toString().contains("store.taobao.com")) {
			System.out.println(page.getHtml());
		}
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) throws Exception {
		 Spider qsSpider = Spider.create(new
				 TMProcessor()).addUrl("https://list.tmall.com/search_product.htm?q=%BB%FA%D0%B5%C3%C5%CB%F8&type=p&spm=a1z10.3-b-s.a2227oh.d100&from=.shop.pc_1_searchbutton")
		 // .addPipeline(new RedisPipeline())
		 // .addPipeline(new JsonFilePipeline())
		 // .addPipeline(new JsonPipeline())
		 .thread(1);
		 qsSpider.start();
	}
}
