import com.jayway.jsonpath.JsonPath;
import ge.edu.freeuni.sdp.iot.service.weather.service.WeatherService;
import org.apache.log4j.BasicConfigurator;
import org.easymock.Mock;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
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
/*
    @Mock
    private WeatherService weather_service;
    private String houseID;

    protected Application configure() {
        return new ResourceConfig(WeatherService.class);
    }

    @Before
    public void setup(){
        BasicConfigurator.configure();
    }

    @Test
    public void test_temperature(){
        try {
            String json = WeatherService.getJsonText(HOUSE_SERVICE_URL);
            String houseID = JsonPath.read(json, "$[0].RowKey._");
            json = WeatherService.getJsonText(WEATHER_API_URL + houseID + "/temperature");
            int f = JsonPath.read(json, "$.temp_f");
            int c = JsonPath.read(json, "$.temp_c");
            Map a = JsonPath.read(json, "$");
            assertEquals(a.size(), 2);
        }
        catch (Exception ex) {
            assertTrue(false);
        }
    }

    @Test
    public void bad_request_test(){
        int status = target("houses/jumberiko/temperature").request().get().getStatus();
        assertEquals(400, status);
    }
*/
}
