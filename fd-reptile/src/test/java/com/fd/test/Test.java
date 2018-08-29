package com.fd.test;

import java.net.URLDecoder;

public class Test {
	
	public static void main(String [] args) {
		String url = "https://zizhanghao.taobao.com/subaccount/monitor/chatRecordJson.htm?action=/subaccount/monitor/ChatRecordQueryAction&eventSubmitDoQueryChatRealtion=anything&_tb_token_=3e3de58e80ba7&_input_charset=utf-8&chatRelationQuery={%22employeeNick%22:%22haier%E6%B5%B7%E5%B0%94%E6%99%BA%E9%9B%85%E4%B8%93%E5%8D%96%E5%BA%97:%E9%9C%B2%E9%9C%B2%22,%22customerNick%22:%22%22,%22start%22:%222018-08-03%22,%22end%22:%222018-08-03%22,%22beginKey%22:null,%22endKey%22:null,%22employeeAll%22:false,%22customerAll%22:true}";
		System.out.println(URLDecoder.decode(url));
		url = "https://zizhanghao.taobao.com/subaccount/monitor/chatRecordHtml.htm?action=/subaccount/monitor/ChatRecordQueryAction&eventSubmitDoQueryChatContent=anything&_tb_token_=3e3de58e80ba7&_input_charset=utf-8&chatContentQuery=%7B%22employeeUserNick%22%3A%5B%22cntaobaohaier%E6%B5%B7%E5%B0%94%E6%99%BA%E9%9B%85%E4%B8%93%E5%8D%96%E5%BA%97%3A%E9%9C%B2%E9%9C%B2%22%5D%2C%22customerUserNick%22%3A%5B%22cntaobao12181125wyyak%22%5D%2C%22employeeAll%22%3Afalse%2C%22customerAll%22%3Afalse%2C%22start%22%3A%222018-08-06%22%2C%22end%22%3A%222018-08-06%22%2C%22beginKey%22%3Anull%2C%22endKey%22%3Anull%7D&site=0&_=1533551192636";
		System.out.println(URLDecoder.decode(url));
	}

}
