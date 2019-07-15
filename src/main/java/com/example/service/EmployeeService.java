package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {
	Employee findById(Long employeeId);

	List<Employee> findAll();

	void saveOrUpdateEmployee(Employee emp);

	void deleteEmployee(Long employeeId);
}
