import com.jayway.jsonpath.JsonPath;
import ge.edu.freeuni.sdp.iot.service.weather.service.WeatherService;
import org.easymock.Mock;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.Map;

import static ge.edu.freeuni.sdp.iot.service.weather.service.Constants.HOUSE_SERVICE_URL;
import static ge.edu.freeuni.sdp.iot.service.weather.service.Constants.WEATHER_API_URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Meko on 10/07/2016.
 */



public class TemperatureTest extends JerseyTest {

    @Mock
    private WeatherService weather_service;
    private String houseID;

    protected Application configure() {
        return new ResourceConfig(WeatherService.class);
    }

    @Test
    public void test_temperature(){
        try {
            String json = WeatherService.getJsonText(HOUSE_SERVICE_URL);
            String houseID = JsonPath.read(json, "$[0].RowKey._");
            json = WeatherService.getJsonText(WEATHER_API_URL + houseID + "/temperature");
            int f = JsonPath.read(json, "$.fahrenheit");
            int c = JsonPath.read(json, "$.celsius");
            Map a = JsonPath.read(json, "$");
            assertEquals(a.size(), 2);
        }
        catch (Exception ex) {
            assertTrue(false);
        }
    }

}
