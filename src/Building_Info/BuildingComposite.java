package Building_Info;

import java.util.ArrayList;
import java.util.Objects;

public class BuildingComposite extends BuildingComponent {

    private ArrayList<BuildingComponent> buildingComponents;

    public BuildingComposite(int idx, String name) {
        super(idx, name);
            buildingComponents = new ArrayList<>();
    }

    public BuildingComponent getComponentById(int id){
        for(BuildingComponent component : buildingComponents){
            if(component.getIdx() == id){
                return component;
            }
        }
        return null;
    }

    public int GetChildCount(){
        return buildingComponents.size();
    }

    BuildingComponent GetLastChild(){
        return buildingComponents.get(buildingComponents.size() - 1);
    }

    public void AddChild(BuildingComponent buildingComponent) {
        buildingComponents.add(buildingComponent);
    }

    /**
     *Oblicza powierzchnię kompozytu
     * @return powierzchnia
     */

    @Override
    public float GetSurface() {
        float sum=0;
        for (BuildingComponent component : buildingComponents) {
            sum+=component.GetSurface();
        }
        return sum;
    }

    /**
     *Oblicza iloś oświetlenia kompozytu
     * @return waty
     */
    public  int GetLampWattage(){
        int sum=0;
        for (BuildingComponent component : buildingComponents)
             sum+=component.GetLampWattage();
        return sum;
    }

    /**
     *Oblicza kubaturę kompozytu
     * @return kubatura
     */
    public  float GetCubature(){
        float sum=0;
        for (BuildingComponent component : buildingComponents)
            sum+=component.GetCubature();
        return sum;
    }

    /**
     *Oblicza ciepło potrzebne do ogrzania kompozytu
     * @return ciepło
     */
    @Override
    public float GetHeating() {
        float sum=0;
        for (BuildingComponent component : buildingComponents)
            sum+=component.GetHeating();
        return sum;
    }

    /**
     *Oblicza oświetlenie na metr kwadratowy kompozytu
     * @return wat/m2
     */
    public  float LampPerMeter2(){
        return this.GetLampWattage()/this.GetSurface();
    }

    /**
     *Oblicza ciepło na metr sześcienny kompozytu
     * @return ciepło/m3
     */
    @Override
    public float HeatPerMeter3() {
        return this.GetHeating()/this.GetCubature();
    }

    /**
     *Wyszukuje części kompozytu, które zużywaja więcej niż maxLevel ciepła na m3
     * @param maxLevel próg powyżej którego wartości będą wyświetlane
     * @return string z danymi komponentów
     */
    public String UsesMoreHeatThan(float maxLevel){
        String useMoreHeat="Id Name\n";
        for (BuildingComponent component : buildingComponents)
            if (component.HeatPerMeter3()>maxLevel)
                useMoreHeat=useMoreHeat+component.getIdx()+" "+component.getName()+"\n";
        return useMoreHeat;
    }
}
