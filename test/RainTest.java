import com.jayway.jsonpath.JsonPath;
import ge.edu.freeuni.sdp.iot.service.weather.service.WeatherService;
import org.easymock.Mock;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.Map;

import static ge.edu.freeuni.sdp.iot.service.weather.service.Constants.HOUSE_SERVICE_URL;
import static ge.edu.freeuni.sdp.iot.service.weather.service.Constants.WEATHER_API_URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tornike on 11.07.2016.
 */
public class RainTest {
    @Test
    public void test_rain(){
        try {
            String json = WeatherService.getJsonText(HOUSE_SERVICE_URL);
            String houseID = JsonPath.read(json, "$[0].RowKey._");
            json = WeatherService.getJsonText(WEATHER_API_URL + houseID + "/rain");
            String rain_value = JsonPath.read(json, "$.rain");
            assertTrue(rain_value.equals("yes") || rain_value.equals("no"));
            Map a = JsonPath.read(json, "$");
            assertEquals(a.size(), 1);
        }
        catch (Exception ex) {
            assertTrue(false);
        }
    }
}
