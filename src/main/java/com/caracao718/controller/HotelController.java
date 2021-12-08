package com.caracao718.controller;

import com.caracao718.domain.Hotel;
import com.caracao718.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    /**
     * Query all hotels nearby a mountain
     * @return hotel list
     */
    @ResponseBody
    @RequestMapping("/hotel/list")
    public List<Hotel> list (Hotel hotel) {
        return hotelService.list(hotel);
    }

}
