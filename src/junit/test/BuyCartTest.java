package junit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.unclewoo.bean.BuyItem;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.bean.product.ProductStyle;

public class BuyCartTest {
	@Test
	public void xxx(){
		List<BuyItem> items = new ArrayList<BuyItem>();
		
		ProductInfo product =  new ProductInfo(5);
		product.addProductStyle(new ProductStyle(19));
		BuyItem buyItem1 = new BuyItem(product, 5);
		items.add(buyItem1);
		
		ProductInfo product1 =  new ProductInfo(5);
		product1.addProductStyle(new ProductStyle(9));
		BuyItem buyItem2 = new BuyItem(product1, 8);
		
//		Assert.assertTrue("两个对象不相等" ,buyItem1.equals(buyItem2));
//		System.out.println(buyItem1.equals(buyItem2));
		
		System.out.println(items.contains(buyItem2));
	}
}
