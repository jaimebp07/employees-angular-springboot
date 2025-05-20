package com.mycompany.mycompany.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mycompany.mycompany.model.Employee;

@Service
public class EmployeeApiClient {

    private final RestTemplate restTemplate;

    EmployeeApiClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Employee> getEmployees(){
        ResponseEntity<Employee[]> response =
                    restTemplate.getForEntity(
                  "https://jsonplaceholder.typicode.com/users",
                  Employee[].class);
                  
                  System.out.println("response --> " + response);
        return Arrays.asList(response.getBody());
    }

    public Employee getEmployeeById(int id){
        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;
        try {
            ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);
            
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
            return null;
        } catch (HttpClientErrorException.NotFound ex) {
            System.out.println("Employee not found with ID: " + id);
            return null;
        } catch (RestClientException ex) {
            System.out.println("Error calling external API: " + ex.getMessage());
            return null;
        }
    }

}
