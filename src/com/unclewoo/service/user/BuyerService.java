package com.unclewoo.service.user;

import java.io.Serializable;

import com.unclewoo.bean.user.Buyer;
import com.unclewoo.service.base.DAO1;

/**
 * 用户业务处理类
 * @author King
 *
 */
public interface BuyerService extends DAO1<Buyer>{
	/**
	 * 重置用户密码
	 * @param username
	 * @param newpassword
	 */
	public void updatePassword(String username, String newpassword);
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean exist(String username);
	/**
	 * 校验用户名及密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validate(String username, String password);
	/**
	 * 启用用户账号
	 * @param entityids
	 */
	public void enable(Serializable... entityids);
}
