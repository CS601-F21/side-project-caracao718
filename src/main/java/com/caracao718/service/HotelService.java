package com.caracao718.service;

import com.caracao718.domain.Hotel;
import com.caracao718.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    public List<Hotel> list (Hotel record) {
        return hotelMapper.list(record);
    }
}
