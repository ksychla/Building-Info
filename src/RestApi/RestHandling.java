package RestApi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/building")
public class RestHandling {

    @GET
    public Response getSurface(){
        return Response.ok("test").build();
    }
}
