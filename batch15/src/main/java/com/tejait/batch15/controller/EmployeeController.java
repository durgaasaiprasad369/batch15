package com.tejait.batch15.controller;


import com.tejait.batch15.model.Employee;
import com.tejait.batch15.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee") // Class-level base path
public class EmployeeController {

    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService service;

    // Create Employee
    @PostMapping("/saveEmp")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
        Employee savedEmp = service.saveEmployee(emp);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    // Update Employee
    @PutMapping("/updateEmp/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        Employee updatedEmp = service.updateEmployeeById(id, emp);
        return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
    }

    // Delete Employee
    @DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Delete successful for ID: " + id);
    }

    // Get Employee by ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getByEmpId(@PathVariable Integer id) {
        Optional<Employee> emp = service.getByEmpId(id);
        return emp.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get All Employees
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmp() {
        List<Employee> list = service.getAllEmp();
        logger.info("Retrieved all employees");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
