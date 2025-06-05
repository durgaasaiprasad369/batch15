package com.tejait.batch15.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejait.batch15.model.Employee;
import com.tejait.batch15.repository.EmployeeRepository;
import com.tejait.batch15.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{


	    @Autowired 
	    private EmployeeRepository repository;

	    @Override
	    public Employee saveEmployee(Employee emp) {
	        // Business logic: Fullname is a concatenation of first and last name
	        String fullname = emp.getFname().concat(emp.getLname());
	        emp.setFullname(fullname);
	        return repository.save(emp);  
	    }

	    @Override
	    public void deleteEmployee(Integer id) {
	        repository.deleteById(id);
	    }

	    @Override
	    public Optional<Employee> getByEmpId(Integer id) {
	        return repository.findById(id);
	    }

	    @Override
	    public List<Employee> getAllEmp() {
	        return repository.findAll();
	    }

	    @Override
	    public Employee updateEmployeeById(int id, Employee updatedEmp) {
	        // Find the employee by ID
	        Employee existingEmp = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

	        // Update fields
	        existingEmp.setFname(updatedEmp.getFname());
	        existingEmp.setLname(updatedEmp.getLname());
	        existingEmp.setFullname(updatedEmp.getFname().concat(updatedEmp.getLname()));
	        existingEmp.setDept(updatedEmp.getDept());
	        existingEmp.setAge(updatedEmp.getAge());
	        existingEmp.setSalary(updatedEmp.getSalary());
	        existingEmp.setEmpCode(updatedEmp.getEmpCode());

	        // Save the updated employee
	        return repository.save(existingEmp);
	    }
	}
