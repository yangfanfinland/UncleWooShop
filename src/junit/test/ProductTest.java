package junit.test;


import java.util.LinkedHashMap;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unclewoo.bean.QueryResult;
import com.unclewoo.bean.product.ProductType;
import com.unclewoo.service.product.ProductTypeService;


public class ProductTest {
	
	private static ApplicationContext cxt;
	private static ProductTypeService productService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		try {
			cxt =  new ClassPathXmlApplicationContext("beans.xml");
			productService = (ProductTypeService)cxt.getBean("productTypeServiceBean");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSave(){
		/*
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("unclewoo");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(new ProductType());
		em.getTransaction().commit();
		em.close();
		factory.close();
		*/
		/*
		ApplicationContext cxt =  new ClassPathXmlApplicationContext("beans.xml");
		DataSource dataSource = (DataSource)cxt.getBean("dataSource");
		System.out.println(dataSource);
		*/
		for(int i=0; i<20; i++){
			ProductType type = new ProductType();
			type.setName(i+ "Fish");
			type.setNote("Fresh!");
			productService.save(type);
		}
	}
	
	@Test
	public void testFind(){
		ProductType type = productService.find(ProductType.class, 1);
		Assert.assertNotNull("Can't get record with id as 1", type);
	}
	
	@Test
	public void testUpdate(){
		ProductType type = productService.find(ProductType.class, 1);
		type.setName("Meat");
		type.setNote("Frozen pig meat!");
		productService.update(type);
	}
	
	@Test
	public void testDelete(){
		productService.delete(ProductType.class, 1);
	}
	
	@Test
	public void testgetScrollData(){
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("typeid", "asc");
		QueryResult<ProductType> qr = productService.getScrollData(ProductType.class);
		for(ProductType t: qr.getResultlist()){
			System.out.println(t.getName());
		}
	}
}
