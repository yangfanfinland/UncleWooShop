package com.unclewoo.service.base;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.unclewoo.bean.QueryResult;
/**
 * 实体操作通用接口
 * @author King
 *
 * @param <T> 实体类型
 */
public interface DAO1<T>{
	
	public String getSubClass();
	
	public Class<T> getEntityClass();
	
	/**
	 * 分页获取记录
	 * @param firstResult 开始索引，如果输入值为-1,即获取全部数据
	 * @param maxReault 每页获取的记录数
	 * @param where 条件语句，不带where关键字 ，条件语句只能使用位置参数，位置参数的索引值以1开始，如:o.username=?1 and o.password=?2
	 * @param params 条件语句出现的位置参数值
	 * @param orderby 排序属性，key为排序属性，value为asc或desc,如:
	 * 	LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("email", "asc");
		orderby.put("password", "desc");
	 * @return 
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxReault, String where, Object[] params,
			LinkedHashMap<String, String> orderby);
	/**
	 * 分页获取记录
	 * @param firstResult 开始索引，如果输入值为-1,即获取全部数据
	 * @param maxReault 每页获取的记录数
	 * @param where 条件语句，不带where关键字 ，条件语句只能使用位置参数，位置参数的索引值以1开始，如:o.username=?1 and o.password=?2
	 * @param params 条件语句出现的位置参数值
	 * @return 
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxReault, String where, Object[] params);
	/**
	 * 分页获取记录
	 * @param firstResult 开始索引，如果输入值为-1,即获取全部数据
	 * @param maxReault 每页获取的记录数
	 * @return 
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxReault);
	/**
	 * 分页获取所有记录
	 * @return 
	 */
	public QueryResult<T> getScrollData();
	/**
	 * 分页获取记录
	 * @param firstResult 开始索引，如果输入值为-1,即获取全部数据
	 * @param maxReault 每页获取的记录数
	 * @param orderby 排序属性，key为排序属性，value为asc或desc,如:
	 * 	LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("email", "asc");
		orderby.put("password", "desc");
	 * @return 
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxReault, LinkedHashMap<String, String> orderby);
	
	
	/**
	 * 保存实体
	 * @param entity 实体对象
	 */
	public void save(T entity);
	/**
	 * 更新实体
	 * @param entity 实体对象
	 */
	public void update(T entity);
	/**
	 * 删除实体
	 * @param entityid 实体标识
	 */
	public void delete(Serializable... entityids);//JPA 规定实体的id属性比粗实现序列化接口
	/**
	 * 获取实体
	 * @param entityid 实体标识
	 * @return 实体对象
	 */
	public T find(Serializable entityid);
	/**
	 * 获取实体的总记录数
	 * @return 总记录数
	 */
	public long getCount();
}
