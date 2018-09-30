package com.unclewoo.service.product.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unclewoo.service.base.DaoSupport;
import com.unclewoo.service.product.ProductStyleService;

@Service
@Transactional
public class ProductStyleServiceBean extends DaoSupport implements ProductStyleService{

	public void setVisibleStatus(Integer[] productstyleids, boolean status) {
		if(productstyleids!=null && productstyleids.length>0){
			StringBuffer jpql = new StringBuffer();
			for(int i=0; i<productstyleids.length;i++){
				jpql.append('?').append((i+2)).append(',');
			}
			jpql.deleteCharAt(jpql.length()-1);
			Query query = em.createQuery("update ProductStyle o set o.visible=?1 where o.id in("+ jpql.toString() +")");
			query.setParameter(1, status);
			for(int i=0; i<productstyleids.length;i++){
				query.setParameter(i+2, productstyleids[i]);
			}
			query.executeUpdate();
		}
	}

}
