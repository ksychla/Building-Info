package Building_Info;

import java.util.ArrayList;

public class BuildingComposite extends BuildingComponent {

    private ArrayList<BuildingComponent> buildingComponents;

    public BuildingComposite(int idx, String name) {
        super(idx, name);
        buildingComponents = new ArrayList<>();
    }

    public void AddChild(BuildingComponent buildingComponent) {
        buildingComponents.add(buildingComponent);
    }

    /**
     *Calculates the surface of a composite
     * @return surface
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
     *Calculates the wattage of a composite
     * @return wattage
     */
    public  int GetLampWattage(){
        int sum=0;
        for (BuildingComponent component : buildingComponents)
             sum+=component.GetLampWattage();
        return sum;
    }

    /**
     *Calculates the cubature of a composite
     * @return cubature
     */
    public  float GetCubature(){
        float sum=0;
        for (BuildingComponent component : buildingComponents)
            sum+=component.GetCubature();
        return sum;
    }

    /**
     *Calculates the heating of a composite
     * @return heating
     */
    @Override
    public float GetHeating() {
        float sum=0;
        for (BuildingComponent component : buildingComponents)
            sum+=component.GetHeating();
        return sum;
    }

    /**
     *Calculates the wattage per square meter of a composite
     * @return wattage/m2
     */
    public  float LampPerMeter2(){
        return this.GetLampWattage()/this.GetSurface();
    }

    /**
     *Calculates the heating per cubic meter of a composite
     * @return heat/m3
     */
    @Override
    public float HeatPerMeter3() {
        return this.GetHeating()/this.GetCubature();
    }

    /**
     *Looks for parts of composite which uses more than maxLevel heat per m3
     * @param maxLevel higher values than maxLevel will be shown
     * @return string with components ids and names
     */
    public String UsesMoreHeatThan(float maxLevel){
        String useMoreHeat="Id Name\n";
        for (BuildingComponent component : buildingComponents)
            if (component.HeatPerMeter3()>maxLevel)
                useMoreHeat=useMoreHeat+component.getIdx()+" "+component.getName()+"\n";
        return useMoreHeat;
    }
}
