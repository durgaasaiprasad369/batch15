package com.tejait.batch15.service;

import java.util.List;
import java.util.Optional;

import com.tejait.batch15.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);

	Employee updateEmployeeById(int id, Employee emp);

	void deleteEmployee(Integer id);

	Optional<Employee> getByEmpId(Integer id);

	List<Employee> getAllEmp();

	

}
