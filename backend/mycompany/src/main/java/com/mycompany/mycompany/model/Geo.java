package com.mycompany.mycompany.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Geo {
    private String lat;
    private String lng;
}
