package com.unclewoo.bean.privilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * 系统权限
 * @author King
 *
 */
@Entity
public class SystemPrivilege {
	private SystemPrivilegePK id;
	/* 权限名称   */
	private String name;
	/* 权限被分配在权限组   */
	private Set<PrivilegeGroup> groups = new HashSet<PrivilegeGroup>();
	
	public SystemPrivilege() {
	}
	
	public SystemPrivilege(SystemPrivilegePK id) {
		this.id = id;
	}
	
	public SystemPrivilege(String module, String privilege, String name) {
		this.id = new SystemPrivilegePK(module, privilege);
		this.name = name;
	}
	
	
	@ManyToMany(mappedBy="privileges", cascade=CascadeType.REFRESH)
	public Set<PrivilegeGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<PrivilegeGroup> groups) {
		this.groups = groups;
	}

	@EmbeddedId
	public SystemPrivilegePK getId() {
		return id;
	}
	public void setId(SystemPrivilegePK id) {
		this.id = id;
	}
	@Column(length=20, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemPrivilege other = (SystemPrivilege) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
