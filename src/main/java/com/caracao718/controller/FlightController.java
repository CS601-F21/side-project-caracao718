package com.caracao718.controller;

import com.caracao718.domain.Flight;
import com.caracao718.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FlightController {
    @Autowired
    private FlightService flightService;

    /**
     * Query flights start on current location
     * @return flight list
     */
    @ResponseBody
    @RequestMapping("/flight/list")
    public List<Flight> list (Flight flight) {

        return flightService.list(flight);
    }

}
