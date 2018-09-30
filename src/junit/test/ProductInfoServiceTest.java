package junit.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unclewoo.bean.product.Brand;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.bean.product.ProductStyle;
import com.unclewoo.bean.product.ProductType;
import com.unclewoo.bean.product.Sex;
import com.unclewoo.service.product.ProductInfoService;

public class ProductInfoServiceTest {

	private static ApplicationContext cxt;
	private static ProductInfoService productInfoService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		try {
			cxt =  new ClassPathXmlApplicationContext("beans.xml");
			productInfoService = (ProductInfoService)cxt.getBean("productInfoServiceBean");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void xxx(){}
	
	@Test
	public void testGetTopSell(){
		List<ProductInfo> products = productInfoService.getTopSell(1, 2);
		for(ProductInfo p : products){
			System.out.println(p.getName());
			System.out.println("---------------------------------------------");
		}
	}
	
	@Test
	public void testSave(){
		ProductInfo product = new ProductInfo();
		product.setName("Rice");
		product.setBaseprice(100f);
		product.setBrand(new Brand("959c0112-3af5-4b5c-b6d2-d78099b2ca05"));
		product.setCode("UI002");
		product.setDescription("Good!");
		product.setMarketprice(600f);
		product.setModel("T60");
		product.setSellprice(300f);
		product.setSexrequest(Sex.NONE);
		product.addProductStyle(new ProductStyle("White","xxx.gif"));
		product.setProducttype(new ProductType(23));
		product.setWeight(50);
		productInfoService.save(product);
	}
}
