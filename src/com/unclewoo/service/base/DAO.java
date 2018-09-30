package com.unclewoo.service.base;

import java.util.LinkedHashMap;

import com.unclewoo.bean.QueryResult;

public interface DAO {
	/**
	 * 清除一级缓存的数据
	 */
	public void clear();
	/**
	 * Store entity
	 * @param entity  entity id
	 */
	public void save(Object entity);
	/**
	 * update entity
	 * @param entity  entity id
	 */
	public void update(Object entity);
	/**
	 * delete entity
	 * @param entityClass  entity class
	 * @param entityid  entity id
	 */
	public <T> void delete(Class<T> entityClass, Object entityid);
	/**
	 * delete entity
	 * @param entityClass  entity class
	 * @param entityids  entity id array
	 */
	public <T> void delete(Class<T> entityClass, Object[] entityids);
	/**
	 * get entity
	 * @param <T>
	 * @param entityClass  entity class
	 * @param entityId  entity id
	 * @return
	 */
	public <T> T find(Class<T> entityClass, Object entityId);
	/**
	 * get divide page data
	 * @param <T>
	 * @param entityClass  entity class
	 * @param firstindex  begin index
	 * @param maxresult  get record number
	 * @return
	 */
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
			int maxresult, String wherejpql, Object[] queryParams, LinkedHashMap<String, String> orderby);
	
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
			int maxresult, String wherejpql, Object[] queryParams);
	
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby);
	
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex,
			int maxresult);
	
	public <T> QueryResult<T> getScrollData(Class<T> entityClass);
}
