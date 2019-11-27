package RestApi;

import Building_Info.BuildingComponent;
import Building_Info.BuildingComposite;
import Building_Info.Room;
import Utils.JsonParser;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//  TODO:   Handling exceptions,
//          better tree composition
//          general bug fix
//          POST json (create building)

@Path("/building")
public class RestHandling extends HttpServlet {

    private JsonParser jsonParser = new JsonParser();

    @GET
    @Path("{id}/surface")
    public Response getSurfaceBuilding(@PathParam("id") Integer id){
        try {
            BuildingComponent building = jsonParser.loadJson(id.toString() + ".json");
            return Response.ok(String.valueOf(building.GetSurface())).build();
        }catch(Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("{id}/cubature")
    public Response getCubatureBuilding(@PathParam("id") Integer id){
        try {
            BuildingComponent building = jsonParser.loadJson(id.toString() + ".json");
            return Response.ok(String.valueOf(building.GetCubature())).build();
        }catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("{id}/heating")
    public Response getHeatingBuilding(@PathParam("id") Integer id){
        try {
            BuildingComponent building = jsonParser.loadJson(id.toString() + ".json");
            return Response.ok(String.valueOf(building.HeatPerMeter3())).build();
        }catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("{id}/wattage")
    public Response getLampWattageBuilding(@PathParam("id") Integer id){
        try {
            BuildingComponent building = jsonParser.loadJson(id.toString() + ".json");
            return Response.ok(String.valueOf(building.LampPerMeter2())).build();
        }catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("{id}/floorId/{floorId}/surface")
    public Response getSurfaceFloor(@PathParam("id") Integer id, @PathParam("floorId") int floorId){
        BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString()+".json");
        BuildingComponent floor = building.getComponentById(floorId);
        return Response.ok(String.valueOf(floor.GetSurface())).build();
    }

    @GET
    @Path("{id}/floorId/{floorId}/cubature")
    public Response getCubatureFloor(@PathParam("id") Integer id, @PathParam("floorId") int floorId){
        BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString()+".json");
        BuildingComponent floor = building.getComponentById(floorId);
        return Response.ok(String.valueOf(floor.GetCubature())).build();
    }

    @GET
    @Path("{id}/floorId/{floorId}/heating")
    public Response getHeatingFloor(@PathParam("id") Integer id, @PathParam("floorId") int floorId){
        BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString()+".json");
        BuildingComponent floor = building.getComponentById(floorId);
        return Response.ok(String.valueOf(floor.GetHeating())).build();
    }

    @GET
    @Path("{id}/floorId/{floorId}/wattage")
    public Response getLampWattageFloor(@PathParam("id") Integer id, @PathParam("floorId") int floorId){
        BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString()+".json");
        BuildingComponent floor = building.getComponentById(floorId);
        return Response.ok(String.valueOf(floor.GetLampWattage())).build();
    }

    @GET
    @Path("{id}/floorId/{floorId}/roomId/{roomId}/surface")
    public Response getSurfaceRoom(@PathParam("id") Integer id, @PathParam("floorId") int floorId, @PathParam("roomId") int roomId){
        BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString()+".json");
        try {
            BuildingComposite floor = (BuildingComposite) building.getComponentById(floorId);
            BuildingComponent room = floor.getComponentById(roomId);
            return Response.ok(String.valueOf(room.GetSurface())).build();
        }catch(NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Path("{id}/floorId/{floorId}/roomId/{roomId}/cubature")
    public Response getCubatureRoom(@PathParam("id") Integer id, @PathParam("floorId") int floorId, @PathParam("roomId") int roomId){
        BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString()+".json");
        try {
            BuildingComposite floor = (BuildingComposite) building.getComponentById(floorId);
            BuildingComponent room = floor.getComponentById(roomId);
            return Response.ok(String.valueOf(room.GetCubature())).build();
        }catch(NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("{id}/floorId/{floorId}/roomId/{roomId}/heating")
    public Response getHeatingRoom(@PathParam("id") Integer id, @PathParam("floorId") int floorId, @PathParam("roomId") int roomId){
        BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString()+".json");
        try {
            BuildingComposite floor = (BuildingComposite) building.getComponentById(floorId);
            BuildingComponent room = floor.getComponentById(roomId);
            return Response.ok(String.valueOf(room.GetHeating())).build();
        }catch(NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("{id}/floorId/{floorId}/roomId/{roomId}/wattage")
    public Response getLampWattageRoom(@PathParam("id") Integer id, @PathParam("floorId") int floorId, @PathParam("roomId") int roomId){
        BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString()+".json");
        try {
            BuildingComposite floor = (BuildingComposite) building.getComponentById(floorId);
            BuildingComponent room = floor.getComponentById(roomId);
            return Response.ok(String.valueOf(room.GetLampWattage())).build();
        }catch(NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("create")
    public Response postBuilding(){
        try {
            BuildingComposite budynek = new BuildingComposite(1, "Budynek");
            BuildingComposite pietro1 = new BuildingComposite(2, "Pietro1");
            pietro1.AddChild(new Room(3, "Poko1", 10, 10, 10));
            pietro1.AddChild(new Room(4, "Poko1", 10, 10, 10));
            budynek.AddChild(pietro1);
            jsonParser.saveJson(budynek, "2.json");
            return Response.ok("").build();
        }catch (Exception e){
            System.out.println(e);
            return Response.status(Response.Status.NOT_FOUND).build();
        }


    }

}
