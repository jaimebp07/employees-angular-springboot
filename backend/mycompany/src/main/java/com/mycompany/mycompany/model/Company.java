package com.mycompany.mycompany.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
