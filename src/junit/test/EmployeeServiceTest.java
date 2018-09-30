package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unclewoo.service.book.OrderItemService;
import com.unclewoo.service.privilege.EmployeeService;

public class EmployeeServiceTest {
	private static ApplicationContext cxt;
	private static EmployeeService employeeService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		try {
			cxt =  new ClassPathXmlApplicationContext("beans.xml");
			employeeService =(EmployeeService)cxt.getBean("employeeServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExist(){
		System.out.println(employeeService.exist("liming"));
	}
	
	@Test 
	public void validate(){
		System.out.println(employeeService.validate("Elainyinran", "123456"));
	}
}
