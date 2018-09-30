package com.unclewoo.service.privilege.impl;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.unclewoo.bean.privilege.Department;
import com.unclewoo.bean.privilege.Employee;
import com.unclewoo.service.base.DaoSupport1;
import com.unclewoo.service.privilege.DepartmentService;

@Service
public class DepartmentServiceBean extends DaoSupport1<Department> implements DepartmentService{
	
	@Override
	public void delete(Serializable... entityids) {
		for(Serializable id : entityids){
			Department department = this.find(id);
			for(Employee employee : department.getEmployees()){
				employee.setDepartment(null);
			}
			em.remove(department);
		}
	}
	
	@Override
	public void save(Department entity) {
		entity.setDepartmentid(UUID.randomUUID().toString());
		super.save(entity);
	}
}
