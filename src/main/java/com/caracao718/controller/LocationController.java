package com.caracao718.controller;

import com.caracao718.domain.Location;
import com.caracao718.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LocationController {
    @Autowired
    private LocationService locationService;

    /**
     * Query locations
     * @return location list
     */
    @ResponseBody
    @RequestMapping("/location/list")
    public List<Location> list () {
        return locationService.list();
    }

}
