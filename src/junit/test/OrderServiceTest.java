package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unclewoo.bean.book.Order;
import com.unclewoo.service.book.GeneratedOrderidService;
import com.unclewoo.service.book.OrderService;

public class OrderServiceTest {
	private static OrderService orderService;
	private static GeneratedOrderidService generatedOrderidService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			orderService = (OrderService)cxt.getBean("orderServiceBean");
			generatedOrderidService = (GeneratedOrderidService)cxt.getBean("generatedOrderidServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void save(){
		generatedOrderidService.init();
		Order order = orderService.createOrder(null, null);
		System.out.println(order.getOrderid());
	}
	
	@Test
	public void updateDeliverFee(){
		orderService.updateDeliverFee("13073100000005", 20f);
	}
}
