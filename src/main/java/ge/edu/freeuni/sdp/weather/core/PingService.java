package ge.edu.freeuni.sdp.weather.core;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("ping")
@Consumes( { MediaType.APPLICATION_JSON})
@Produces( { MediaType.APPLICATION_JSON})
public class PingService {
    @GET
    public Response get() {
        return Response.ok().build();
    }
}
