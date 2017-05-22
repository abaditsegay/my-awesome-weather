package com.weather.assignment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by abadi on 5/13/17 in com.weather.assignment.model.
 */
public class Weather {
    private String maxTemp;
    private String minTemp;
    private String humidity;
    private String pressure;

    @JsonCreator
    public Weather(@JsonProperty String maxTemp, @JsonProperty String minTemp, @JsonProperty String humidity, @JsonProperty String pressure ){
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public Weather(){}

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }


}
