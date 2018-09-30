package junit.test;


import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.xerces.impl.dv.util.Base64;
import org.junit.Test;


public class Base64Test {
	@Test 
	public void encode(){
		String url = "/customer/shopping/orderconfirm.action?id=1&name=xxxxxxx";//原文
		String code = new String(Base64.encode(url.getBytes()));//编码后的字符串
		
		//String url = new String(Base64.encodeBase64("/customer/shopping/comfirm.do?id=xxx&name=xxx".getBytes()));
		System.out.println(code);
	}
	
	@Test 
	public void decode(){
		String url = new String(Base64.decode("L1VuY2xlV29vU2hvcC9jdXN0b21lci9zaG9wcGluZy9wYXlfY2FydC5hY3Rpb24="));
		System.out.println(url);
	}
	
	@Test 
	public void xxx(){
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHH");
		String time = format.format(new Date());
		
		//Date todayDate = format.parse(time.replaceAll("\\d{2}\\b", "00"), new ParsePosition(0));
		System.out.println(time);
	}
}
