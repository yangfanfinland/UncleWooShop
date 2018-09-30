package com.unclewoo.service.product.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.compass.core.Compass;
import org.compass.core.CompassTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unclewoo.bean.product.Brand;
import com.unclewoo.bean.product.ProductInfo;
import com.unclewoo.service.base.DaoSupport;
import com.unclewoo.service.product.ProductInfoService;
import com.unclewoo.service.product.ProductTypeService;

@Service
@Transactional
public class ProductInfoServiceBean extends DaoSupport implements ProductInfoService{
	@Resource(name="productTypeServiceBean") private ProductTypeService productTypeService;
	
	
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public List<ProductInfo> getViewHistory(Integer[] productids, int maxResult){
		StringBuffer jpql = new StringBuffer();
		for(int i=0; i<productids.length; i++){
			jpql.append('?').append(i).append(',');
		}
		jpql.deleteCharAt(jpql.length()-1);
		Query query = em.createQuery("select o from ProductInfo o where o.id in("+ jpql.toString() +")");
		for(int i=0; i<productids.length; i++){
			query.setParameter(i, productids[i]);
		}
		query.setFirstResult(0).setMaxResults(maxResult);
		return query.getResultList();
	}
	
	
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public List<ProductInfo> getTopSell(Integer typeid, int maxResult){
		List<Integer> typeids = new ArrayList<Integer>();
		typeids.add(typeid);
		getTypeids(typeids, new Integer[]{typeid});
		StringBuffer n = new StringBuffer();
		for(int i=0; i<typeids.size();i++){
			n.append('?').append((i+2)).append(',');
		}
		n.deleteCharAt(n.length()-1);
		Query query = em.createQuery("select o from ProductInfo o where o.commend=?1 and o.producttype.typeid in("+n.toString()+")");
		query.setParameter(1, true);
		for(int i=0; i<typeids.size();i++){
			query.setParameter(i+2, typeids.get(i));
		}
		query.setFirstResult(0).setMaxResults(maxResult);
		return query.getResultList();
	}
	
	private void getTypeids(List<Integer> outtypeids, Integer[] typeids){
		List<Integer> subtypeids = productTypeService.getSubTypeid(typeids);
		if(subtypeids!=null && subtypeids.size()>0){
			outtypeids.addAll(subtypeids);
			Integer[] ids = new Integer[subtypeids.size()];
			for(int i=0; i<subtypeids.size(); i++){
				ids[i]=subtypeids.get(i);
			}
			getTypeids(outtypeids, ids);
		}
	
	}
	
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public List<Brand> getBrandsByProductTypeid(Integer[] typeids){
			if(typeids!=null && typeids.length>0){
			StringBuffer jpql = new StringBuffer();
			for(int i=0; i<typeids.length;i++){
				jpql.append('?').append((i+1)).append(',');
			}
			jpql.deleteCharAt(jpql.length()-1);
			Query query = em.createQuery("select o from Brand o where o.code in(select p.brand.code from ProductInfo p where p.producttype.typeid in("+ jpql.toString() +") group by p.brand.code)");
			for(int i=0; i<typeids.length;i++){
				query.setParameter(i+1, typeids[i]);
			}
			return query.getResultList();
		}
			return null;
	}
	
	@Override
	public void setVisibleStatus(Integer[] productids, boolean status) {
		if(productids!=null && productids.length>0){
			StringBuffer jpql = new StringBuffer();
			for(int i=0; i<productids.length;i++){
				jpql.append('?').append((i+2)).append(',');
			}
			jpql.deleteCharAt(jpql.length()-1);
			Query query = em.createQuery("update ProductInfo o set o.visible=?1 where o.id in("+ jpql.toString() +")");
			query.setParameter(1, status);
			for(int i=0; i<productids.length;i++){
				query.setParameter(i+2, productids[i]);
			}
			query.executeUpdate();
		}
	}

	@Override
	public void setCommendStatus(Integer[] productids, boolean status) {
		if(productids!=null && productids.length>0){
			StringBuffer jpql = new StringBuffer();
			for(int i=0; i<productids.length;i++){
				jpql.append('?').append((i+2)).append(',');
			}
			jpql.deleteCharAt(jpql.length()-1);
			Query query = em.createQuery("update ProductInfo o set o.commend=?1 where o.id in("+ jpql.toString() +")");
			query.setParameter(1, status);
			for(int i=0; i<productids.length;i++){
				query.setParameter(i+2, productids[i]);
			}
			query.executeUpdate();
		}
	}

}
