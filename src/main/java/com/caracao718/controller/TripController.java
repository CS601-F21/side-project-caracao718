package com.caracao718.controller;

import com.caracao718.domain.Flight;
import com.caracao718.domain.Trip;
import com.caracao718.domain.SysUser;
import com.caracao718.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TripController {
    @Autowired
    private TripService tripService;

    /**
     * query my trips
     *
     * @return list
     */
    @ResponseBody
    @RequestMapping("/trip/list")
    public List<Flight> list(HttpSession session) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        return tripService.list(user.getId());
    }

    /**
     * When add a flight to my trip, this method will execute
     *
     * @param record  data from web page
     * @param session http session
     * @return
     */
    @ResponseBody
    @RequestMapping("/trip/add")
    public String add(Trip record, HttpSession session) {
        SysUser user = (SysUser) session.getAttribute("loginUser");
        record.setUserId(user.getId());

        // when user had add same flight, method will return exists
        Integer num = tripService.checkExists(record);
        if (num > 0) {
            return "Current flight had added in my trips";
        } else {
            tripService.insert(record);
            return "Add trip success!";
        }
    }
}
