/**
 * Created by Meko on 10/06/2016.
 */
import ge.edu.freeuni.sdp.iot.service.weather.service.PingService;

import javax.ws.rs.core.*;
import static org.junit.Assert.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
public class test extends JerseyTest{

    @Override
    protected Application configure() {
        return new ResourceConfig(PingService.class);
    }

    @Test
    public void ping_test(){
        Response actual = target("ping").request().get();
        assertEquals(
                Response.Status.OK.getStatusCode(),
                actual.getStatus());
    }

}
