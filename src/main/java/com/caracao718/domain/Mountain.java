package com.caracao718.domain;

import lombok.Data;


@Data
public class Mountain {
    private Integer id;
    private String name;
    private Integer locationId;
    private String locationName;
    private String zipCode;
    private String weather;
}
