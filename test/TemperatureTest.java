
import com.jayway.jsonpath.JsonPath;
import ge.edu.freeuni.sdp.iot.service.weather.service.WeatherService;
import org.easymock.Mock;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Application;

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

    @Before
    public void setup(){
        houseID = "a1bc00fb-4724-476a-a553-d65d2c1bac0e";
    }


    @Test
    public void test_temperature(){
        String json = WeatherService.getJsonText("http://iot-weather.herokuapp.com/webapi/houses/"+ houseID +"/temperature");
        System.out.print(json);

        JsonPath.read(json, "$.temp_f");
        assert(true);
    }

}
