package com.caracao718.service;

import com.caracao718.domain.Location;
import com.caracao718.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationMapper locationMapper;

    public Location selectById (Integer id) {
        return locationMapper.selectById(id);
    }

    public List<Location> list () {
        return locationMapper.list();
    }
}
