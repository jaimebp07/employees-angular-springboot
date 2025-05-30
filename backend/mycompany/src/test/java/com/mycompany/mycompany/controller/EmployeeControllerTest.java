package com.mycompany.mycompany.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mycompany.mycompany.model.Employee;
import com.mycompany.mycompany.services.EmployeeApiClient;
import com.mycompany.mycompany.testutils.TestDataLoader;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeApiClient employeeApiClient;

    @InjectMocks
    private  EmployeeController employeeController;
    
     @Test
     public void shouldReturnListOfEmployees_WhenGetAllEmployeesIsCalled(){

        //Given
        //List<Employee> employees = assertDoesNotThrow(this::loadEmployeesFromJson);
        List<Employee> employees = assertDoesNotThrow(() ->
            TestDataLoader.loadJson("mocks/employees.json", new TypeReference<List<Employee>>() {})
        );
        when(employeeApiClient.getEmployees()).thenReturn(employees);
        
        //When
       ResponseEntity<List<Employee>> result = employeeController.getAllEmployees();

        //Then
        assertNotNull(result.getBody(), "La respuesta del controlador es null");
        assertEquals(10, result.getBody().size());

    }
}
