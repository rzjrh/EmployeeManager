package com.RezaAk.web.employeemanager.repositories;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RezaAk. web.employeemanager.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long> {
	List <Employee> findAll();
}
