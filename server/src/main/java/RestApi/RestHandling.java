package RestApi;

import Building_Info.BuildingComponent;
import Building_Info.BuildingComposite;
import Utils.JsonParser;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.*;


/**
 *  Klasa obsługująca REST api
 */
@Path("/building")
public class RestHandling extends HttpServlet {

    private JsonParser jsonParser = new JsonParser();

    /**
     * Funkcja podająca łączną powierzchnię budynku
     *
     * @param id numer identyfikujący budynek
     * @return  Status wykonanej operacji
     */
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

    /**
     * Funkcja podająca łączną kubaturę budynku
     *
     * @param id numer identyfikujący budynek
     * @return Status wykonanej operacji
     */
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

    /**
     * Funkcja podająca zużycie energii na ogrzewanie budynku
     *
     * @param id numer identyfikujący budynek
     * @return Status wykonanej operacji
     */
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

    /**
     * Funkcja podająca moc oświetlenia na powierzchnię w budynku
     *
     * @param id numer identyfikujący budynek
     * @return Status wykonanej operacji
     */
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

    /**
     * Funkcja podająca łączną powierzchnię piętra
     *
     * @param id numer identyfikujący budynek
     * @param floorId numer identyfikujący piętro
     * @return Status wykonanej operacji
     */
    @GET
    @Path("{id}/floorId/{floorId}/surface")
    public Response getSurfaceFloor(@PathParam("id") Integer id, @PathParam("floorId") int floorId){
        try {
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString() + ".json");
            BuildingComponent floor = building.getComponentById(floorId);
            return Response.ok(String.valueOf(floor.GetSurface())).build();
        }catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca łączną kubaturę piętra
     *
     * @param id numer identyfikujący budynek
     * @param floorId numer identyfikujący piętro
     * @return Status wykonanej operacji
     */
    @GET
    @Path("{id}/floorId/{floorId}/cubature")
    public Response getCubatureFloor(@PathParam("id") Integer id, @PathParam("floorId") int floorId){
        try {
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString() + ".json");
            BuildingComponent floor = building.getComponentById(floorId);
            return Response.ok(String.valueOf(floor.GetCubature())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca zużycie energii na piętro
     *
     * @param id numer identyfikujący budynek
     * @param floorId numer identyfikujący piętro
     * @return Status wykonanej operacji
     */
    @GET
    @Path("{id}/floorId/{floorId}/heating")
    public Response getHeatingFloor(@PathParam("id") Integer id, @PathParam("floorId") int floorId){
        try {
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString() + ".json");
            BuildingComponent floor = building.getComponentById(floorId);
            return Response.ok(String.valueOf(floor.GetHeating())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funckja podająca moc oświetlenia na powierzchnię na piętrze
     *
     * @param id numer identyfikujący budynek
     * @param floorId numer identyfikujący piętro
     * @return Status wykonanej operacji
     */
    @GET
    @Path("{id}/floorId/{floorId}/wattage")
    public Response getLampWattageFloor(@PathParam("id") Integer id, @PathParam("floorId") int floorId){
        try {
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(id.toString() + ".json");
            BuildingComponent floor = building.getComponentById(floorId);
            return Response.ok(String.valueOf(floor.GetLampWattage())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca powierzchnię pomieszczenia
     *
     * @param id numer identyfikujący budynek
     * @param floorId numer identyfikujący piętro
     * @param roomId numer identyfikujący pokój
     * @return Status wykonanej operacji
     */
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

    /**
     * Funkcja podająca kubaturę pomieszczenia
     *
     * @param id numer identyfikujący budynek
     * @param floorId numer identyfikujący piętro
     * @param roomId numer identyfikujący pokój
     * @return Status wykonanej operacji
     */
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

    /**
     * Funkcja podająca zużycie energii na pomieszczenie
     *
     * @param id numer identyfikujący budynek
     * @param floorId numer identyfikujący piętro
     * @param roomId numer identyfikujący pokój
     * @return Status wykonanej operacji
     */
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

    /**
     * Funckja podająca moc oświetlenia na powierzchnię w pomieszczeniu
     *
     * @param id numer identyfikujący budynek
     * @param floorId numer identyfikujący piętro
     * @param roomId numer identyfikujący pokój
     * @return Status wykonanej operacji
     */
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

    /**
     * Funkcja tworząca nowy budynek w systemie przez metodę POST
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę POST
     * @return Status wykonanej operacji
     */
    @POST
    @Path("create")
    public Response postBuilding(String string){
        try{
            jsonParser.saveFromString(string);
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
        }
        return Response.ok("Upload complete").build();
    }

    /**
     * Funkcja zwracająca budynek w postaci json
     *
     * @param id numer identyfikujący budynek
     * @return Status wykonanej operacji
     */
    @GET
    @Path("{id}/get")
    public Response getBuilding(@PathParam("id") Integer id){
        try{
            String out = jsonParser.getStringFromJson(id.toString()+".json");
            return Response.ok(out).build();
        }catch (IOException e){
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
