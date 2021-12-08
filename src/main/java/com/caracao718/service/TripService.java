package com.caracao718.service;

import com.caracao718.domain.Flight;
import com.caracao718.domain.Trip;
import com.caracao718.mapper.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripMapper tripMapper;

    public Integer checkExists (Trip record) {
        return tripMapper.checkExists(record);
    }
    public List<Flight> list (Integer userId) {
        return tripMapper.list(userId);
    }

    public int insert (Trip record) {
        return tripMapper.insert(record);
    }
}
