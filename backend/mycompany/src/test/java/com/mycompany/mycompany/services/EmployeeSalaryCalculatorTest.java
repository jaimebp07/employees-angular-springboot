package com.mycompany.mycompany.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mycompany.mycompany.model.Address;
import com.mycompany.mycompany.model.Company;
import com.mycompany.mycompany.model.Employee;
import com.mycompany.mycompany.model.Geo;

public class EmployeeSalaryCalculatorTest {

    private static Employee employee;

    @BeforeAll
    public static void initEmployee(){
        employee = Employee.builder()
        .id(1)
        .name("Leanne Graham")
        .username("Bret")
        .email("Sincere@april.biz")
        .address(Address.builder()
            .street("Kulas Light")
            .suite("Apt. 556")
            .city("Gwenborough")
            .zipCode("92998-3874")
            .geo(Geo.builder()
                .lat("-37.3159")
                .lng("81.1496")
                .build())
            .build())
        .phone("1-770-736-8031 x56442")
        .website("hildegard.org")
        .company(Company.builder()
            .name("Romaguera-Crona")
            .catchPhrase("Multi-layered client-server neural-net")
            .bs("harness real-time e-markets")
            .build())
        .build();
    }

    @Test
    public void shouldReturnAnnualSalary_whenMonthlySalaryIsProvided(){
        EmployeeSalaryCalculator employeeSalaryCalculator = new EmployeeSalaryCalculator();
        double annualSalary = employeeSalaryCalculator.calculateAnnualSalary(employee);
        assertEquals(12000, annualSalary);
    }
}
