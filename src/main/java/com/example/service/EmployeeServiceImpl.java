package com.example.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;

	@Override
	public Employee findById(Long employeeId) {
		return employeeRepository.findById(employeeId).orElse(new Employee());
	}

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void saveOrUpdateEmployee(Employee emp) {
		employeeRepository.save(emp);

	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.findById(employeeId)
				.ifPresent(employee1 -> employeeRepository.deleteById(employee1.getId()));
	}
}
