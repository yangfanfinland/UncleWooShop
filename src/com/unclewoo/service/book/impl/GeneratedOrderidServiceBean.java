package com.unclewoo.service.book.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.unclewoo.bean.book.GeneratedOrderid;
import com.unclewoo.service.base.DaoSupport1;
import com.unclewoo.service.book.GeneratedOrderidService;

@Service
public class GeneratedOrderidServiceBean extends DaoSupport1<GeneratedOrderid>
		implements GeneratedOrderidService{
	public void init(){
		if(this.getCount()==0){
			GeneratedOrderid go = new GeneratedOrderid();
			go.setId("order");
			this.save(go);
		}
	}
	
	public int buildOrderid(){
		em.createQuery("update GeneratedOrderid o set o.orderid=orderid+1 where o.id=?1")
			.setParameter(1, "order").executeUpdate();
		em.flush();
		GeneratedOrderid go = this.find("order");
		return go.getOrderid();
	}
}
