package com.caracao718.service;

import com.caracao718.domain.Mountain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Update weather of location every day
 */
@Service
public class WeatherUpdate {
    @Autowired
    RestTemplate template;
    @Autowired
    MountainService mountainService;

    /**
     * Daily weather updates
     */
    @Scheduled(initialDelay=86400000, fixedDelay=86400000)
    public void update(){
        List<Mountain> list = mountainService.list();
        for (Mountain mountain : list) {
            String url = "https://api.openweathermap.org/data/2.5/weather?zip="+mountain.getZipCode()+",US&appid=fc66eba0fd6733614ef4e5ca5bcb36e0";
            String weather = template.getForObject(url, String.class);
            mountainService.updateWeather(mountain.getId(), weather);
        }
        System.out.println("update finish");
    }
}
