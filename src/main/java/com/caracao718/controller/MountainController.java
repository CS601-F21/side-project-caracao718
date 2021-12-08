package com.caracao718.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.caracao718.domain.Mountain;
import com.caracao718.service.MountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MountainController {
    @Autowired
    private MountainService mountainService;


    /**
     * Query mountains
     * @return mountain list
     */
    @ResponseBody
    @RequestMapping("/mountain/list")
    public List<Mountain> list () {
        return mountainService.list();
    }

    /**
     * Query Mountain weather info
     * @param mountainId from web page
     * @param locationId from web page
     * @param model spring model
     * @return mountain_detail.html page
     */
    @RequestMapping("/detail")
    public String detail (Integer mountainId, Integer locationId, Model model) {

        Mountain mountain = mountainService.selectById(mountainId);
        JSONObject root = JSON.parseObject(mountain.getWeather());

        JSONArray weather = root.getJSONArray("weather");
        JSONObject main = root.getJSONObject("main");
        JSONObject wind = root.getJSONObject("wind");

        model.addAttribute("weather",weather.getJSONObject(0).getString("description"));
        model.addAttribute("temp_min","Min temperature: "+calcTemp(main.getDoubleValue("temp_min")));
        model.addAttribute("temp_max","Max temperature: "+calcTemp(main.getDoubleValue("temp_max")));
        model.addAttribute("pressure","Pressure: "+main.getString("pressure")+" hPa");
        model.addAttribute("humidity","Humidity: "+main.getString("humidity")+"%");
        model.addAttribute("wind_speed","Wind speed: "+wind.getString("speed")+" M/s");
        model.addAttribute("mountain_name", mountain.getName());
        model.addAttribute("mountain_id", mountainId);
        return "mountain_detail";
    }

    /**
     * convert temp from Kelvins to Fahrenheit
     * @param kelvins
     * @return Fahrenheit
     */
    private String calcTemp(double b){
        return Math.floor(((b - 273.15) * 1.8 + 32)) + " ℉";
    }
}
