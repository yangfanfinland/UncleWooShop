package com.unclewoo.service.product.impl;

import javax.annotation.Resource;

import org.compass.core.Compass;
import org.compass.core.CompassTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unclewoo.bean.QueryResult;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.service.product.ProductSearchService;

@Service @Transactional
public class ProductSearchServiceBean implements ProductSearchService {
	private CompassTemplate compassTemplate;
	
	@Resource
	public void setCompass(Compass compass){
		this.compassTemplate = new CompassTemplate(compass);
	}
	
	public QueryResult<ProductInfo> query(String keyword, int firstResult, int maxResult){
		return compassTemplate.execute(new QueryCallback(keyword,firstResult,maxResult));
	}
}
