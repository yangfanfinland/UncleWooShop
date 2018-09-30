package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unclewoo.service.book.OrderItemService;

public class OrderItemServiceTest {
	private static ApplicationContext cxt;
	private static OrderItemService orderItemService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		try {
			cxt =  new ClassPathXmlApplicationContext("beans.xml");
			orderItemService =(OrderItemService)cxt.getBean("orderItemServiceBean");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void updateAmount(){
		orderItemService.updateAmount(1, 10);
	}
	
	@Test
	public void delete(){
		orderItemService.delete(1);
	}
}
