package RestApi;

import Building_Info.BuildingComponent;
import Utils.JsonParser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/building")
public class RestHandling {

    @GET
    @Path("surface/{id}")
    public Response getSurface(@PathParam("id") Integer id){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
        return Response.ok(String.valueOf(building.GetSurface())).build();
    }

    @GET
    @Path("cubature/{id}")
    public Response getCubature(@PathParam("id") Integer id){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
        return Response.ok(String.valueOf(building.GetCubature())).build();
    }

    @GET
    @Path("heating/{id}")
    public Response getHeating(@PathParam("id") Integer id){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
        return Response.ok(String.valueOf(building.GetHeating())).build();
    }

    @GET
    @Path("wattage/{id}")
    public Response getLampWattage(@PathParam("id") Integer id){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
        return Response.ok(String.valueOf(building.GetLampWattage())).build();
    }
}
