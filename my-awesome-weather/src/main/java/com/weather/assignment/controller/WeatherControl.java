package com.weather.assignment.controller;

import com.weather.assignment.exception.DataNotFoundException;
import com.weather.assignment.model.Weather;
import com.weather.assignment.wetherclient.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abadi on 5/13/17 in com.weather.assignment.controller.
 */
@Controller
public class WeatherControl {

    @Autowired
    public WeatherClient weatherClient;

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping (value = "/weather/{zipcode}", method = RequestMethod.GET)
    @ResponseBody
    public Weather getWeather(@PathVariable("zipcode") String zipcode){
        return weatherClient.getWeather(zipcode);
    }
//
//    @RequestMapping(value = "/weather/data/", method = RequestMethod.POST, consumes = "application/json")
//    public void createWeather(@RequestBody Weather data) {
//        System.out.println(data.getHumidity());
//    }
}
