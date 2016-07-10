package ge.edu.freeuni.sdp.iot.service.weather.service;

import com.jayway.jsonpath.JsonPath;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import static ge.edu.freeuni.sdp.iot.service.weather.service.Constants.*;
/**
 * Created by Tornike on 24.06.2016.
 */

@Path("houses")
@Consumes( { MediaType.APPLICATION_JSON})
@Produces( { MediaType.APPLICATION_JSON})
public class WeatherService {

    @GET
    @Path("{house_id}/rain")
    public RainInfo getRainInfo(@PathParam("house_id") String house_id){
        RainInfo info = new RainInfo();
        String coordinates = getCoordinates(house_id);
        setRainChance(info, coordinates);
        return info;
    }

    private void setRainChance(RainInfo info, String coordinates){
        try {
            String json = getJsonText(HOURLY_FOREST_URL + coordinates + ".json");
            String value = "no";

            for (int i = 0; i < 24; i++){
                String id = String.valueOf(i);
                String weather_condition = JsonPath.read(json, "$.hourly_forecast[" + id + "].condition");
                if (weather_condition.contains("Rain") || weather_condition.contains("RAIN") || weather_condition.contains("rain"))
                    value = "yes";
            }

            info.setValue(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @GET
    @Path("{house_id}/temperature")
    public TemperatureInfo getTemperatureInfo(@PathParam("house_id") String house_id){
        TemperatureInfo info = new TemperatureInfo();
        String coordinates = getCoordinates(house_id);
        setTemperature(info, coordinates);
        return info;
    }

    private void setTemperature(TemperatureInfo info, String coordinates){
        try {
            String json = getJsonText(WEATHER_CONDITIONS_URL + coordinates + ".json");
            int temp_c = JsonPath.read(json, "$.current_observation.temp_c");
            int temp_f = JsonPath.read(json, "$.current_observation.temp_f");
            info.setCelsius(temp_c);
            info.setFahrenheit(temp_f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getCoordinates(String house_id){
        String changed_coordinates = "";
        try {
            String json = getJsonText(HOUSE_SERVICE_URL  + house_id);
            String coordinates = JsonPath.read(json, "$.geo_location._");

            int len = coordinates.length();
            for (int i = 0; i < len; i++) {
                char c = coordinates.charAt(i);
                if (c == '.')
                    changed_coordinates += ',';
                else if (c == ',')
                    changed_coordinates += '.';
                else
                    changed_coordinates += c;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return changed_coordinates;
    }

    String getJsonText(String address){
        String json = "";
        try {
            URL url = new URL(address);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String part;
            while (null != (part = br.readLine())) {
                json += part;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }


}
