package com.mycompany.mycompany.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String suite;
    private String city;
    @JsonProperty("zipcode")
    private String zipCode;
    private Geo geo;
}
