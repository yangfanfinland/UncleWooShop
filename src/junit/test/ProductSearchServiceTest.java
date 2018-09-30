package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unclewoo.bean.QueryResult;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.service.product.ProductSearchService;

public class ProductSearchServiceTest {
	private static ApplicationContext cxt;
	private static ProductSearchService productSearchService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		try {
			cxt =  new ClassPathXmlApplicationContext("beans.xml");
			productSearchService = (ProductSearchService)cxt.getBean("productSearchServiceBean");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery(){
		QueryResult<ProductInfo> qr = productSearchService.query("番茄酱", 0, 5);
		for(ProductInfo product : qr.getResultlist()){
			System.out.println(product.getName());
		}
		System.out.println(qr.getTotalrecord());
	}
}
