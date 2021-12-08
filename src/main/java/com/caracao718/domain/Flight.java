package com.caracao718.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Flight {
    private Integer id;
    private String originLocation;
    private String originAirport;
    private String destinationLocation;
    private String destinationAirport;
    private String airlineName;
    private String planeNo;

    private String startTimeStr;
    private String endTimeStr;
    private BigDecimal price;
}
