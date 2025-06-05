package com.tejait.batch15.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.model.Employee;
import com.tejait.batch15.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



// controller --> service --> serviceimpl --> repository
@RestController
@RequestMapping("employee") // class level mapping
public class EmployeeController {

    @Autowired
    private EmployeeService service; // inject EmployeeService

    // Save employee (POST)
    @RequestMapping(value = "saveEmp", method = RequestMethod.POST)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
        Employee saveEmp = service.saveEmployee(emp);
        return new ResponseEntity<Employee>(saveEmp, HttpStatus.CREATED);
    }

    // Update employee (PUT)
    @RequestMapping(value = "updateEmp/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        Employee updateEmp = service.updateEmployeeById(id, emp); // correct method call for update
        return new ResponseEntity<>(updateEmp, HttpStatus.OK);
    }

    // Delete employee (DELETE)
    @RequestMapping(value = "deleteEmp/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
        return new ResponseEntity<String>("Delete successful for ID: " + id, HttpStatus.OK);
    }

    // Get employee by ID (GET)
    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getByEmpId(@PathVariable Integer id) {
        Optional<Employee> emp = service.getByEmpId(id);
        
        if(emp.isPresent())
	    {
		   return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
	    }
	    else
	    {
	       return new ResponseEntity<Employee>( HttpStatus.NOT_FOUND);
	    }
       
    }

    // Get all employees (GET)
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmp() {
        List<Employee> list = service.getAllEmp();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
//er-->end point-->url--> http://localhost:8080/employee/saveEmp