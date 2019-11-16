package RestApi;

import Building_Info.BuildingComponent;
import Utils.JsonParser;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//  TODO:   Handling exceptions,
//          better tree composition
//          general bug fix

@Path("/building")
public class RestHandling extends HttpServlet {

    @GET
    @Path("{id}/surface")
    public Response getSurfaceBuilding(@PathParam("id") Integer id){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
        return Response.ok(String.valueOf(building.GetSurface())).build();
    }

    @GET
    @Path("{id}/cubature")
    public Response getCubatureBuilding(@PathParam("id") Integer id){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
        return Response.ok(String.valueOf(building.GetCubature())).build();
    }

    @GET
    @Path("{id}/heating")
    public Response getHeatingBuilding(@PathParam("id") Integer id){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
        return Response.ok(String.valueOf(building.GetHeating())).build();
    }

    @GET
    @Path("{id}/wattage")
    public Response getLampWattageBuilding(@PathParam("id") Integer id){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
        return Response.ok(String.valueOf(building.GetLampWattage())).build();
    }

    @GET
    @Path("{id}/floor/{floor}/surface")
    public Response getSurface(@PathParam("id") Integer id, @PathParam("floor") String floor){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
//        TODO: Add floor
//        BuildingComponent floorBuildingComponent = building.(...)
        return Response.ok(String.valueOf(building.GetSurface())).build();
    }

    @GET
    @Path("{id}/floor/{floor}/cubature")
    public Response getCubature(@PathParam("id") Integer id, @PathParam("floor") String floor){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
//        TODO
        return Response.ok(String.valueOf(building.GetCubature())).build();
    }

    @GET
    @Path("{id}/floor/{floor}/heating")
    public Response getHeating(@PathParam("id") Integer id, @PathParam("floor") String floor){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
//        TODO
        return Response.ok(String.valueOf(building.GetHeating())).build();
    }

    @GET
    @Path("{id}/floor/{floor}/wattage")
    public Response getLampWattage(@PathParam("id") Integer id, @PathParam("floor") String floor){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
//        TODO
        return Response.ok(String.valueOf(building.GetLampWattage())).build();
    }

    @GET
    @Path("{id}/floor/{floor}/room/{room}/surface")
    public Response getSurface(@PathParam("id") Integer id, @PathParam("floor") String floor, @PathParam("room") String room){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
//        TODO
        return Response.ok(String.valueOf(building.GetSurface())).build();
    }

    @GET
    @Path("{id}/floor/{floor}/room/{room}/cubature")
    public Response getCubature(@PathParam("id") Integer id, @PathParam("floor") String floor, @PathParam("room") String room){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
//        TODO
        return Response.ok(String.valueOf(building.GetCubature())).build();
    }

    @GET
    @Path("{id}/floor/{floor}/room/{room}/heating")
    public Response getHeating(@PathParam("id") Integer id, @PathParam("floor") String floor, @PathParam("room") String room){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
//        TODO
        return Response.ok(String.valueOf(building.GetHeating())).build();
    }

    @GET
    @Path("{id}/floor/{floor}/room/{room}/wattage")
    public Response getLampWattage(@PathParam("id") Integer id, @PathParam("floor") String floor, @PathParam("room") String room){
        JsonParser jsonParser = new JsonParser();
        BuildingComponent building = jsonParser.loadJson(id.toString()+".json");
//        TODO
        return Response.ok(String.valueOf(building.GetLampWattage())).build();
    }

    @GET
    @Path("/test")
    public Response testRest(){
        return Response.ok("Test").build();
    }

}
