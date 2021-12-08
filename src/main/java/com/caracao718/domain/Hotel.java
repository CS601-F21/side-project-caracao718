package com.caracao718.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Hotel {
    private Integer id;
    private Integer mountainId;
    private String name;
    private Integer mark;
    private Integer bed;
    private BigDecimal price;
    private String address;
    private String phone;
}
