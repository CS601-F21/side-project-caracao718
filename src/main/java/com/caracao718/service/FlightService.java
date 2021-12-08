package com.caracao718.service;

import com.caracao718.domain.Flight;
import com.caracao718.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightMapper flightMapper;

    public List<Flight> list (Flight record) {
        return flightMapper.list(record);
    }

    public List<Flight> listAll () {
        return flightMapper.listAll();
    }
}
