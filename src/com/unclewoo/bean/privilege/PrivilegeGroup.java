package com.unclewoo.bean.privilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 权限组
 * @author King
 *
 */
@Entity
public class PrivilegeGroup {
	private String groupid;
	/** 权限组名称   **/
	private String name;
	/** 改组具有的权限   **/
	private Set<SystemPrivilege> privileges = new HashSet<SystemPrivilege>();
	/** 使用改权限组的员工   **/
	private Set<Employee> employees = new HashSet<Employee>();
	
	public PrivilegeGroup() {
	}
	
	public PrivilegeGroup(String groupid) {
		this.groupid = groupid;
	}
	
	@ManyToMany(mappedBy="groups", cascade=CascadeType.REFRESH)
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Id @Column(length=40)
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	@Column(length=30,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	@JoinTable(name="ps", inverseJoinColumns={
			@JoinColumn(name="module",referencedColumnName="module"),
			@JoinColumn(name="privilege",referencedColumnName="privilege")}
			,joinColumns=@JoinColumn(name="group_id")
	)
	public Set<SystemPrivilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<SystemPrivilege> privileges) {
		this.privileges = privileges;
	}
	
	/**
	 * 王权限组里添加权限
	 * @param privilege
	 */
	public void addSystemPrivilege(SystemPrivilege privilege){
		this.privileges.add(privilege);
	}
}
