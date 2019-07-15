package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	List<Employee> findByName(String name);
}
