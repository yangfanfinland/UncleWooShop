package com.unclewoo.service.product.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unclewoo.bean.product.ProductType;
import com.unclewoo.service.base.DaoSupport;
import com.unclewoo.service.product.ProductTypeService;

@Service
@Transactional
public class ProductTypeServiceBean extends DaoSupport implements ProductTypeService {

	@Override
	public <T> void delete(Class<T> entityClass, Object[] entityids) {
		
		if(entityids!=null && entityids.length>0){
			StringBuffer jpql = new StringBuffer();
			for(int i=0; i<entityids.length; i++){
				jpql.append("?").append(i+2).append(",");
			}
			jpql.deleteCharAt(jpql.length()-1);
			Query query = em.createQuery("update ProductType o set o.visible=?1 where o.typeid in ("+ jpql.toString() +")")
					.setParameter(1, false);
	
			for(int i=0; i<entityids.length; i++){
				query.setParameter(i+2, entityids[i]);
			}
			query.executeUpdate();
		}
	}
	
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public List<Integer> getSubTypeid(Integer[] parentids){
		if(parentids!=null&&parentids.length>0){
			StringBuffer jpql = new StringBuffer();
			for(int i=0; i<parentids.length; i++){
				jpql.append('?').append((i+1)).append(',');
			}
			jpql.deleteCharAt(jpql.length()-1);
			Query query = em.createQuery("select o.typeid from ProductType o where o.parent.typeid in("+ jpql.toString() +")");
			for(int i=0; i<parentids.length; i++){
				query.setParameter(i+1, parentids[i]);
			}
			return query.getResultList();
		}
		return null;
		
	}
	
}
