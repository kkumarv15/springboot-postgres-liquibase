package com.example.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/postgresApp")
public class EmployeeResource {

	@Resource
	private EmployeeService employeeService;

	@GetMapping(value = "/employees/{id}")
	public Employee getEmployee(@PathVariable("id") Long employeeId) {
		return employeeService.findById(employeeId);
	}

	@GetMapping(value = "/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@PostMapping(value = "/employees")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdateEmployee(employee);
	}

	@PutMapping(value = "/employees")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdateEmployee(employee);
	}

	@DeleteMapping(value = "/employees/{id}")
	public void deleteEmployee(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
}
