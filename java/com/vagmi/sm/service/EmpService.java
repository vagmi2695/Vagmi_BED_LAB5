package com.vagmi.sm.service;


import java.util.List;

import com.vagmi.sm.entity.Employee;


public interface EmpService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);

	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
