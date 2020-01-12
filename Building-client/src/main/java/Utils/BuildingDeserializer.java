package Utils;

import Building_Info.BuildingComponent;
import Building_Info.BuildingComposite;
import Building_Info.Room;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *  Klasa pomocnicza nadpisująca serializator w klasie JsonParser
 */
public class BuildingDeserializer implements JsonDeserializer<BuildingComponent> {

    /**
     * Funckja nadpisująca domyślny serializator
     *
     * @return Obiekt zdeserializowanego budynku
     */
    @Override
    public BuildingComposite deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jobject = json.getAsJsonObject();

        BuildingComposite budynek = new BuildingComposite(jobject.get("idx").getAsInt(), jobject.get("name").getAsString());
        for (JsonElement temp_pietro:jobject.get("buildingComponents").getAsJsonArray()) {

            JsonObject jpietro = temp_pietro.getAsJsonObject();
            BuildingComposite pietro = new BuildingComposite(jpietro.get("idx").getAsInt(), jpietro.get("name").getAsString());

            for (JsonElement temp_pokoj:jpietro.get("buildingComponents").getAsJsonArray()) {

                JsonObject room = temp_pokoj.getAsJsonObject();
                pietro.AddChild(new Room(room.get("idx").getAsInt(), room.get("name").getAsString(),
                        room.get("surface").getAsFloat(), room.get("lampWattage").getAsInt(),
                        room.get("cubature").getAsInt(), room.get("heating").getAsFloat()));
            }
            budynek.AddChild(pietro);

        }

        return budynek;
    }
}
