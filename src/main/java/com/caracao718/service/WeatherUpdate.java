package com.caracao718.service;

import com.caracao718.domain.Mountain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    @Autowired
    ResourceLoader resourceLoader;

    /**
     * Daily weather updates
     */
    @Scheduled(initialDelay=86400000, fixedDelay=86400000)
    public void update(){
        String token = readToken();
        List<Mountain> list = mountainService.list();
        for (Mountain mountain : list) {
            String url = "https://api.openweathermap.org/data/2.5/weather?zip="+mountain.getZipCode()+",US&appid="+token;
            String weather = template.getForObject(url, String.class);
            mountainService.updateWeather(mountain.getId(), weather);
        }
        System.out.println("update finish");
    }

    private String readToken(){
        Resource resource = resourceLoader.getResource("classpath:token.txt");
        try {
            InputStreamReader isr = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String data;
            while((data = br.readLine()) != null) {
                return data;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
