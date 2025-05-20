package com.mycompany.mycompany.model;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

}
