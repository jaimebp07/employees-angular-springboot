package com.mycompany.mycompany.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.mycompany.model.Employee;
import com.mycompany.mycompany.services.EmployeeApiClient;

@RestController
public class EmployeeController {

    private final EmployeeApiClient employeeApiClient;

    public EmployeeController(EmployeeApiClient employeeApiClient){
        this.employeeApiClient = employeeApiClient;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
       List<Employee> response = employeeApiClient.getEmployees();
        if(response == null || response.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hola")
    public String hola() {
        return "hola empleado";
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employeeResponse = employeeApiClient.getEmployeeById(id);
        if(employeeResponse == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeResponse);
    }
}
