package com.unclewoo.bean.user;
/**
 * 性别
 * @author King
 *
 */
public enum Gender {
	MAN{
		public String getName(){return "男";}
	},
	WOMEN{
		public String getName(){return "女";}
	};
	public abstract String getName();
	
}
