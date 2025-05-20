package com.mycompany.mycompany.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeResponse {

    private List<Employee> data;

}
