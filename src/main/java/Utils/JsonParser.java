package Utils;

import Building_Info.BuildingComponent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 *  Klasa obsługująca serializację do i z plików .json
 */
public class JsonParser {

    /**
     * Funckja serializująca obiekt budynku do pliku .json
     *
     * @param building Objekt budynku, który ma być serializowany
     * @param json_name Nazwa pliku .json
     */
    public void saveJson(BuildingComponent building, String json_name){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter parser = new FileWriter("out/"+json_name);

            gson.toJson(building,parser);
            parser.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Funckja deserializująca plik .json do obiektu budynku
     *
     * @param json_name Nazwa pliku .json
     * @return Obiekt budynku
     */
    public BuildingComponent loadJson(String json_name){
        Gson gson = new GsonBuilder().registerTypeAdapter(BuildingComponent.class, new BuildingDeserializer()).create();
        BuildingComponent building = null;

        try {
            Reader jsonreader = new FileReader(json_name);
            building = gson.fromJson(jsonreader, BuildingComponent.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return building;

    }

    /**
     * Funkcja zapisująca plik json w postaci ciągu znaków do pliku
     *
     * @param json plik json w postaci ciągu znaków
     * @throws IOException wyjątek IO wyrzucany gdy podany plik nie nadaje się do zapisu
     */
    public File saveFromString(String json) throws IOException{
        File file = null;
        int num = 0;
        for(int i=1;i<1000;i++){
            file = new File("out/"+i+".json");
            if(file.createNewFile()){
                num = i;
                break;
            }
        }
        OutputStream out = new FileOutputStream(file);
        out.write(json.getBytes());
        try {
            BuildingComponent building = loadJson("out/"+num + ".json");
        }catch (Exception e){
            file.delete();
            throw new IllegalStateException();
        }
        return file;
    }

    /**
     * Funkcja zwracająca zawartość pliku json w postaci ciągu znaków
     *
     * @param jsonName plik json
     * @return zawartość pliku json
     * @throws IOException wyjątek IO wyrzucany gdy podany plik nie istnieje
     */
    public String getStringFromJson(String jsonName) throws IOException{
        InputStream in = new FileInputStream("out/"+jsonName);
        BufferedReader buf = new BufferedReader(new InputStreamReader(in));

        String line = buf.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        while(line != null){
            stringBuilder.append(line).append("\n");
            line = buf.readLine();
        }
        return stringBuilder.toString();
    }
}
