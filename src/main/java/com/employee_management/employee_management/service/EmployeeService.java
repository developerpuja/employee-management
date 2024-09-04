package com.employee_management.employee_management.service;

import com.employee_management.employee_management.entity.Employee;
import com.employee_management.employee_management.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        Employee employee1 = null;
        try {
            employee1 = employeeRepository.save(employee);
        } catch (Exception ex) {
            log.error("Failure saving employee", ex);
        }
        return employee1;
    }

    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getAllEmployeeData() {
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployeeDetails(Employee employee) {
        Employee updatedEmp = null;
       try {
           Employee existingEmp = employeeRepository.findById(employee.getId()).get();
           if (existingEmp != null) {
               existingEmp.setName(employee.getName());
               existingEmp.setCity(employee.getCity());
               existingEmp.setDepartment(employee.getDepartment());
               existingEmp.setPinCode(employee.getPinCode());
               updatedEmp = employeeRepository.save(existingEmp);
           } else {
               log.error("No Employee found for update.");
           }
       } catch (Exception e) {
           log.error("Error updating employee detail.", e);
       }
       return updatedEmp;
    }
}
