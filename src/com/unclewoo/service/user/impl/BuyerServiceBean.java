package com.unclewoo.service.user.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unclewoo.bean.user.Buyer;
import com.unclewoo.service.base.DaoSupport;
import com.unclewoo.service.base.DaoSupport1;
import com.unclewoo.service.user.BuyerService;
import com.unclewoo.utils.MD5;

@Service
//spring只会对定义在本类的方法应用事务通知（Advice） 父类必须开始事务，子类可以不必加
public class BuyerServiceBean extends DaoSupport1<Buyer> implements BuyerService{
	
	public void updatePassword(String username, String newpassword){
		em.createQuery("update Buyer o set o.password=?1 where o.username=?2")
		.setParameter(1, MD5.MD5Encode(newpassword)).setParameter(2, username).executeUpdate();
	}
	
	@Override
	public void delete(Serializable... entityids) {
		setVisible(false, entityids);
	}
	
	public void enable(Serializable... entityids){
		setVisible(true, entityids);
	}
	private void setVisible(boolean visible, Serializable... entityids) {
		if(entityids!=null && entityids.length>0){
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<entityids.length; i++){
				sb.append('?').append(i+2).append(',');
			}
			sb.deleteCharAt(sb.length()-1);
			Query query = em.createQuery("update Buyer o set o.visible=?1 where o.username in("+ sb.toString() +")");
			query.setParameter(1, visible);
			for(int i=0; i<entityids.length; i++){
				query.setParameter(i+2, entityids[i]);
			}
			query.executeUpdate();
		}
	}
	
	
	
	@Override
	public void save(Buyer entity) {
		entity.setPassword(MD5.MD5Encode(entity.getPassword()));
		super.save(entity);
	}
	
	public boolean exist(String username){
		long count = (Long)em.createQuery("select count(o) from Buyer o where o.username=?1")
		.setParameter(1, username).getSingleResult();
		return count>0;
	}

	public boolean validate(String username, String password){
		long count = (Long)em.createQuery("select count(o) from Buyer o where o.username=?1 and o.password=?2")
		.setParameter(1, username).setParameter(2, MD5.MD5Encode(password)).getSingleResult();
		return count>0;
	}
}
