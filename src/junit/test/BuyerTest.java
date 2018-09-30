package junit.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unclewoo.bean.QueryResult;
import com.unclewoo.bean.user.Buyer;
import com.unclewoo.service.user.BuyerService;

public class BuyerTest {
	
	private static BuyerService buyerService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		try {
			ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
			buyerService = (BuyerService)act.getBean("buyerServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getSubClass(){
		System.out.println(buyerService.getSubClass());
		System.out.println(buyerService.getEntityClass());
	}
	
	@Test
	public void save(){
		for(int i=1; i<30; i++){
			Buyer buyer = new Buyer();
			buyer.setUsername("liming" + i);
			buyer.setPassword("123456");
			buyer.setEmail("yangfanpan88@yahoo.com.cn" + i);
			buyerService.save(buyer);
		}
	}
	
	@Test
	public void find(){
		Buyer buyer = buyerService.find("liming");
		System.out.println(buyer.getEmail());
	}
	
	@Test
	public void delete(){
		Buyer buyer = buyerService.find("liming");
		buyerService.delete(buyer.getUsername());
	}
	
	@Test
	public void update(){
		Buyer buyer = buyerService.find("liming");
		buyer.setEmail("yangfanfinland@gmail.com");
		buyerService.update(buyer);
	}
	
	@Test
	public void count(){
		System.out.println(buyerService.getCount());
	}
	
	@Test
	public void getScrollData(){
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("email", "asc");
		orderby.put("password", "desc");
		QueryResult<Buyer> qr = buyerService.getScrollData(0, 5, "o.email=?1", new Object[]{"666"});
		for(Buyer buyer : qr.getResultlist()){
			System.out.println(buyer.getEmail());
		}
		System.out.println("总记录数:" + qr.getTotalrecord());
	}
	
	@Test
	public void exist(){
		System.out.println(buyerService.exist("liming112"));
	}
	
}
