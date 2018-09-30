package com.unclewoo.service.privilege.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.unclewoo.bean.QueryResult;
import com.unclewoo.bean.privilege.PrivilegeGroup;
import com.unclewoo.bean.privilege.SystemPrivilege;
import com.unclewoo.service.base.DaoSupport1;
import com.unclewoo.service.privilege.SystemPrivilegeService;

@Service
public class SystemPrivilegeServiceBean extends DaoSupport1<SystemPrivilege> implements SystemPrivilegeService{
	
	public void saves(List<SystemPrivilege> privileges){
		for(SystemPrivilege p : privileges){
			super.save(p);
		}
	}
	
	@Override
	public QueryResult<SystemPrivilege> getScrollData(int firstResult, int maxReault, String where, Object[] params,
			LinkedHashMap<String, String> orderby){
		String entityName = getEntityName(entityClass);
		String whereql = where!=null && !"".equals(where.trim()) ? " where "+ where : "" ;
		Query query = em.createQuery("select o from "+ entityName +" o" + whereql + buildOrderby(orderby));
		if(firstResult!=-1 && maxReault!=-1)
			query.setFirstResult(firstResult).setMaxResults(maxReault);
		setQueryParameter(query, params);
		QueryResult<SystemPrivilege> qr = new QueryResult<SystemPrivilege>();
		qr.setResultlist(query.getResultList());
		//因为DaoSupport1中默认方法不针对联合主键。
		//修改方案：当前类重写分页方法,将"select count(o) from POJO o" count()中的o改为出其主键外的任一属性(eg:o.name)既可
		//query = em.createQuery("select count(o) from "+ entityName +" o"+ whereql);
		query = em.createQuery("select count(o.name) from "+ entityName +" o"+ whereql);
		setQueryParameter(query, params);
		qr.setTotalrecord((Long)query.getSingleResult());
		return qr;
	}
	@Override
	public QueryResult<SystemPrivilege> getScrollData(){
		return getScrollData(-1, -1, null, null, null);
	}
}
