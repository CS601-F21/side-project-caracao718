package com.caracao718.domain;

import lombok.Data;

@Data
public class FavoriteMountain {
    private Integer id;
    private Integer userId;
    private Integer mountainId;
    private String mountainName;
    private String locationName;
}
