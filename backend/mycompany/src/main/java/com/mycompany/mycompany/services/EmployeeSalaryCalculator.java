package com.mycompany.mycompany.services;

import org.springframework.stereotype.Service;

import com.mycompany.mycompany.model.Employee;

@Service
public class EmployeeSalaryCalculator {

    public double calculateAnnualSalary(Employee employee) {
        return 12;
    }
}
