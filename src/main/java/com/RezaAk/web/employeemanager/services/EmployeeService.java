package com.RezaAk.web.employeemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RezaAk. web.employeemanager.models.Employee;
import com.RezaAk. web.employeemanager.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService (EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> allEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findEmployee(Long id) {
		Optional<Employee> e = employeeRepository.findById(id);
    	
    	if(e.isPresent()) {
            return e.get();
    	}
    	else {
    	    return null;
    	}
	}
}
