package com.employee_management.employee_management.controller;

import com.employee_management.employee_management.entity.Employee;
import com.employee_management.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/save")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        ResponseEntity<Employee> response = null;
        if (employee != null) {
            Employee emp =  employeeService.saveEmployee(employee);
            response =  new ResponseEntity<>(emp, HttpStatus.CREATED);
        } else {
            response =  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee) {
        ResponseEntity<Employee> response = null;
        if (employee != null) {
            Employee emp =  employeeService.updateEmployeeDetails(employee);
            response =  new ResponseEntity<>(emp, HttpStatus.OK);
        } else {
            response =  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployeeData() {
        return new ResponseEntity<>(employeeService.getAllEmployeeData(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
