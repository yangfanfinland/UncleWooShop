package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unclewoo.bean.product.Brand;
import com.unclewoo.service.product.BrandService;

public class BrandServiceTest {
	private static ApplicationContext cxt;
	private static BrandService brandService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		try {
			cxt =  new ClassPathXmlApplicationContext("beans.xml");
			brandService = (BrandService)cxt.getBean("brandServiceBean");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSave(){
	
			brandService.save(new Brand("老干妈","/images/brand/2013/07/10/10/dsfdsfdsfdsfdsfdsfdsfs.gif"));
	
	}
}
