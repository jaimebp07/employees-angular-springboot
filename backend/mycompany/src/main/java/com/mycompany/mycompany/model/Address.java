package com.mycompany.mycompany.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {

    private String street;
    private String suite;
    private String city;
    @JsonProperty("zipcode")
    private String zipCode;
    private Geo geo;
}
