package com.unclewoo.service.product.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unclewoo.bean.product.Brand;
import com.unclewoo.service.base.DaoSupport;
import com.unclewoo.service.product.BrandService;

@Service
@Transactional
public class BrandServiceBean extends DaoSupport implements BrandService{

	@Override
	public void save(Object entity) {
		((Brand)entity).setCode(UUID.randomUUID().toString());
		super.save(entity);
	}

}
