package com.unclewoo.service.base;

import java.util.LinkedHashMap;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.dialect.FirebirdDialect;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unclewoo.bean.QueryResult;

@Transactional
public class DaoSupport implements DAO{
	@PersistenceContext
	protected EntityManager em;
	
	public void clear(){
		em.clear();
	}

	public void save(Object entity) {
		em.persist(entity);
	}

	public void update(Object entity) {
		em.merge(entity);
	}

	public <T> void delete(Class<T> entityClass, Object entityid) {
		delete(entityClass, new Object[]{entityid});
	}
	
	public <T> void delete(Class<T> entityClass, Object[] entityids) {
		for(Object id : entityids){
			em.remove(em.getReference(entityClass, id));
		}
		
	}

	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public <T> T find(Class<T> entityClass, Object entityId) {
		return em.find(entityClass, entityId);
	}

	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public <T> QueryResult<T> getScrollData(Class<T> entityClass,
			int firstindex, int maxresult, String wherejpql,
			Object[] queryParams) {
		return getScrollData(entityClass, firstindex, maxresult, wherejpql, queryParams, null);
	}

	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public <T> QueryResult<T> getScrollData(Class<T> entityClass,
			int firstindex, int maxresult, LinkedHashMap<String, String> orderby) {
		return getScrollData(entityClass, firstindex, maxresult, null,null, orderby);
	}

	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public <T> QueryResult<T> getScrollData(Class<T> entityClass,
			int firstindex, int maxresult) {
		return getScrollData(entityClass, firstindex, maxresult, null,null, null);
	}

	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public <T> QueryResult<T> getScrollData(Class<T> entityClass) {
		return getScrollData(entityClass, -1, -1);
	}
	
	@Transactional(readOnly=true, propagation=Propagation.NOT_SUPPORTED)
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult
			, String wherejpql, Object[] queryParams, LinkedHashMap<String, String> orderby) {
		QueryResult qr = new QueryResult<T>();
		String entityname = getEntityName(entityClass);
		Query query = em.createQuery("select o from "+ entityname +" o "+(wherejpql==null? "": "where "+ wherejpql)+ buildOrderby(orderby));
//		query.setFirstResult(firstindex);
//		query.setMaxResults(maxresult);
		setQueryParams(query, queryParams);
		if(firstindex!=-1 && maxresult!=-1)
			query.setFirstResult(firstindex).setMaxResults(maxresult);
		qr.setResultlist(query.getResultList());
		query = em.createQuery("select count(o) from "+ entityname +" o "+(wherejpql==null? "": "where "+ wherejpql));
		setQueryParams(query, queryParams);
		qr.setTotalrecord((Long)query.getSingleResult());
		
		return qr;
	}
	
	protected void setQueryParams(Query query, Object[] queryParams) {
		if(queryParams!=null && queryParams.length>0){
			for(int i=0; i<queryParams.length; i++){
				query.setParameter(i+1, queryParams[i]);
			}
		}
	}
	
	/**
	 * found order by query
	 * @param orderby
	 * @return
	 */
	//order by o.key desc,o.key2 asc
	protected String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuffer orderbyql = new StringBuffer("");
		if(orderby!=null && orderby.size()>0){
			orderbyql.append(" order by ");
			for(String key : orderby.keySet()){
				orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length()-1);
		}
			return orderbyql.toString();
	}
	
	/**
	 * get entity name
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	protected <T> String getEntityName(Class<T> entityClass){
		String entityname = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if(entity.name()!=null && !"".equals(entity.name())){
			entityname = entity.name();
		}
		return entityname;
	}
}
