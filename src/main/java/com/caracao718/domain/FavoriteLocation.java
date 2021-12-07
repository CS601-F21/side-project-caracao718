package com.caracao718.domain;

import lombok.Data;

@Data
public class FavoriteLocation {
    private Integer id;
    private Integer userId;
    private Integer locationId;
    private String locationName;
}
