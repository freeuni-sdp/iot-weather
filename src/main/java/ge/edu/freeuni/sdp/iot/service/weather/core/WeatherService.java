package ge.edu.freeuni.sdp.iot.service.weather.core;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Tornike on 24.06.2016.
 */

@Path("houses")
@Consumes( { MediaType.APPLICATION_JSON})
@Produces( { MediaType.APPLICATION_JSON})
public class WeatherService {

    @GET
    @Path("{house_id}/temperature")
    public TemperatureInfo getTemperatureInfo(@PathParam("house_id") String house_id, TemperatureInfo info){
        String coordinates = getCoordinates(house_id);
        setTemperature(info, coordinates);
        return info;
    }

    private void setTemperature(TemperatureInfo info, String coordinates){
        try {
            URL url = new URL("http://api.wunderground.com/api/147c55ed4df9f4cf/conditions/q/" + coordinates + ".json"); // TODO constantebshi
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String json = "";
            String part;
            while (null != (part = br.readLine())) {
                json += part;
            }

            float temp_c = JsonPath.read(json, "$.current_observation.temp_c");
            float temp_f = JsonPath.read(json, "$.current_observation.temp_f");

            info.setCelsius(Math.round(temp_c));
            info.setFahrenheit(Math.round(temp_f));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getCoordinates(String house_id){
        String changed_coordinates = "";
        try {
            URL url = new URL("http://iot-house-registry.apiblueprint.org/houses/" + house_id); // TODO constantebshi
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String json = "";
            String part;
            while (null != (part = br.readLine())) {
                json += part;
            }

            JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
            String coordinates = jsonObject.get("geo_location").getAsString();
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


}
