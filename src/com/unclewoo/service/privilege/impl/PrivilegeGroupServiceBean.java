package com.unclewoo.service.privilege.impl;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.unclewoo.bean.privilege.Employee;
import com.unclewoo.bean.privilege.PrivilegeGroup;
import com.unclewoo.service.base.DaoSupport1;
import com.unclewoo.service.privilege.PrivilegeGroupService;
@Service
public class PrivilegeGroupServiceBean extends DaoSupport1<PrivilegeGroup> implements PrivilegeGroupService{

	@Override
	public void save(PrivilegeGroup entity) {
		PrivilegeGroup group = (PrivilegeGroup)entity;
		group.setGroupid(UUID.randomUUID().toString());
		super.save(entity);
	}
	
	@Override
	public void delete(Serializable... entityids) {
		for(Serializable id: entityids){
			PrivilegeGroup group = this.find(id);
			for(Employee employee : group.getEmployees()){
				employee.getGroups().remove(group);
			}
			em.remove(group);
		}
	}
}
