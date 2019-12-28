package RestApi;

import Building_Info.BuildingComponent;
import Building_Info.BuildingComposite;
import Utils.JsonParser;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @return  Status wykonanej operacji
     */
    @GET
    @Path("surface")
    public Response getSurfaceBuilding(String string){
        try{
            File file = jsonParser.saveFromString(string);
            BuildingComponent building = jsonParser.loadJson(file.getName());
            return Response.ok(building.GetSurface()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca łączną kubaturę budynku
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @return Status wykonanej operacji
     */
    @GET
    @Path("cubature")
    public Response getCubatureBuilding(String string){
        try{
            File file = jsonParser.saveFromString(string);
            BuildingComponent building = jsonParser.loadJson(file.getName());
            return Response.ok(building.GetCubature()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca zużycie energii na ogrzewanie budynku
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @return Status wykonanej operacji
     */
    @GET
    @Path("heating")
    public Response getHeatingBuilding(String string){
        try{
            File file = jsonParser.saveFromString(string);
            BuildingComponent building = jsonParser.loadJson(file.getName());
            return Response.ok(building.GetHeating()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca moc oświetlenia na powierzchnię w budynku
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @return Status wykonanej operacji
     */
    @GET
    @Path("wattage")
    public Response getLampWattageBuilding(String string){
        try{
            File file = jsonParser.saveFromString(string);
            BuildingComponent building = jsonParser.loadJson(file.getName());
            return Response.ok(building.GetLampWattage()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca łączną powierzchnię piętra
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @param floor numer identyfikujący piętro
     * @return Status wykonanej operacji
     */
    @GET
    @Path("floor/{floor}/surface")
    public Response getSurfaceFloor(String string, @PathParam("floor") int floor){
        try {
            File file = jsonParser.saveFromString(string);
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(file.getName());
            BuildingComponent f = building.getComponentById(floor);
            return Response.ok(String.valueOf(f.GetSurface())).build();
        }catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca łączną kubaturę piętra
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @param floor numer identyfikujący piętro
     * @return Status wykonanej operacji
     */
    @GET
    @Path("floor/{floor}/cubature")
    public Response getCubatureFloor(String string, @PathParam("floor") int floor){
        try {
            File file = jsonParser.saveFromString(string);
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(file.getName());
            BuildingComponent f = building.getComponentById(floor);
            return Response.ok(String.valueOf(f.GetCubature())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca zużycie energii na piętro
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @param floor numer identyfikujący piętro
     * @return Status wykonanej operacji
     */
    @GET
    @Path("floor/{floor}/heating")
    public Response getHeatingFloor(String string, @PathParam("floor") int floor){
        try {
            File file = jsonParser.saveFromString(string);
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(file.getName());
            BuildingComponent f = building.getComponentById(floor);
            return Response.ok(String.valueOf(f.GetHeating())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funckja podająca moc oświetlenia na powierzchnię na piętrze
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @param floor numer identyfikujący piętro
     * @return Status wykonanej operacji
     */
    @GET
    @Path("floor/{floor}/wattage")
    public Response getLampWattageFloor(String string, @PathParam("floor") int floor){
        try {
            File file = jsonParser.saveFromString(string);
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(file.getName());
            BuildingComponent f = building.getComponentById(floor);
            return Response.ok(String.valueOf(f.GetLampWattage())).build();
        }catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca powierzchnię pomieszczenia
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @param floor numer identyfikujący piętro
     * @param room numer identyfikujący pokój
     * @return Status wykonanej operacji
     */
    @GET
    @Path("floor/{floor}/room/{room}/surface")
    public Response getSurfaceRoom(String string, @PathParam("floor") int floor, @PathParam("room") int room){
        try {
            File file = jsonParser.saveFromString(string);
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(file.getName());
            BuildingComposite f = (BuildingComposite) building.getComponentById(floor);
            BuildingComponent r = f.getComponentById(room);
            return Response.ok(String.valueOf(r.GetSurface())).build();
        }catch(IOException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    /**
     * Funkcja podająca kubaturę pomieszczenia
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @param floor numer identyfikujący piętro
     * @param room numer identyfikujący pokój
     * @return Status wykonanej operacji
     */
    @GET
    @Path("floor/{floor}/room/{room}/cubature")
    public Response getCubatureRoom(String string, @PathParam("floor") int floor, @PathParam("room") int room){
        try {
            File file = jsonParser.saveFromString(string);
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(file.getName());
            BuildingComposite f = (BuildingComposite) building.getComponentById(floor);
            BuildingComponent r = f.getComponentById(room);
            return Response.ok(String.valueOf(r.GetCubature())).build();
        }catch(IOException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funkcja podająca zużycie energii na pomieszczenie
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @param floor numer identyfikujący piętro
     * @param room numer identyfikujący pokój
     * @return Status wykonanej operacji
     */
    @GET
    @Path("floor/{floor}/room/{room}/heating")
    public Response getHeatingRoom(String string, @PathParam("floor") int floor, @PathParam("room") int room){
        try {
            File file = jsonParser.saveFromString(string);
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(file.getName());
            BuildingComposite f = (BuildingComposite) building.getComponentById(floor);
            BuildingComponent r = f.getComponentById(room);
            return Response.ok(String.valueOf(r.GetHeating())).build();
        }catch(IOException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Funckja podająca moc oświetlenia na powierzchnię w pomieszczeniu
     *
     * @param string plik json w postaci ciagu znaków otrzymany przez metodę GET
     * @param floor numer identyfikujący piętro
     * @param room numer identyfikujący pokój
     * @return Status wykonanej operacji
     */
    @GET
    @Path("floor/{floor}/room/{room}/wattage")
    public Response getLampWattageRoom(String string, @PathParam("floor") int floor, @PathParam("room") int room){
        try {
            File file = jsonParser.saveFromString(string);
            BuildingComposite building = (BuildingComposite) jsonParser.loadJson(file.getName());
            BuildingComposite f = (BuildingComposite) building.getComponentById(floor);
            BuildingComponent r = f.getComponentById(room);
            return Response.ok(String.valueOf(r.GetLampWattage())).build();
        }catch(IOException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
