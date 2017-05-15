package com.weather.assignment.wetherclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.weather.assignment.exception.DataNotFoundException;
import com.weather.assignment.exception.ServerErrorException;
import com.weather.assignment.model.Weather;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by abadi on 5/13/17 in com.weather.assignment.weatherclient.
 */
@Component
public class WeatherClient {
    private Logger logger = LoggerFactory.getLogger(WeatherClient.class);
    public Weather getWeather(String zipcode) {
        String output = "";
        Weather weather = new Weather();
        logger.info("Getting data for Zipcode: " + zipcode);

        //returning empty data if the zipcode is empty
        if (zipcode.equals("undefined")){
            return new Weather();
        }

        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://api.openweathermap.org/data/2.5/weather");
            MultivaluedMap<String, String> params = new MultivaluedMapImpl();
            params.add("q", zipcode);
            //This one has the access key to the weather API
            params.add("APPID", "3a5666449dbea1c32416cc6a93e62d87");

            ClientResponse response = webResource
                    .queryParams(params)
                    .accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() == 500) {
                throw new ServerErrorException(zipcode);
            }

            if (response.getStatus() != 200) {
                throw new DataNotFoundException(zipcode);
            }

            output = response.getEntity(String.class);
            JSONObject jsonObject = new JSONObject(output);
            JSONObject weatherJson = (JSONObject) jsonObject.get("main");
            weather.setMaxTemp(weatherJson.get("temp_max").toString());
            weather.setMinTemp(weatherJson.get("temp_min").toString());
            weather.setPressure(weatherJson.get("pressure").toString());
            weather.setHumidity(weatherJson.get("humidity").toString());

        } catch (Exception e) {

            e.printStackTrace();

        }

        return weather;
    }
}
