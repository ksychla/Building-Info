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

    @Override
    public float GetSurface() {
        float sum=0;
        for (BuildingComponent component : buildingComponents) {
            sum+=component.GetSurface();
        }
        return sum;
    }

    public  int GetLampWattage(){
        int sum=0;
        for (BuildingComponent component : buildingComponents)
             sum+=component.GetLampWattage();
        return sum;
    }

    public  float GetCubature(){
        float sum=0;
        for (BuildingComponent component : buildingComponents)
            sum+=component.GetCubature();
        return sum;
    }

    @Override
    public float GetHeating() {
        float sum=0;
        for (BuildingComponent component : buildingComponents)
            sum+=component.GetHeating();
        return sum;
    }

    public  float LampPerMeter2(){
        return this.GetLampWattage()/this.GetSurface();
    }

    @Override
    public float HeatPerMeter3() {
        return this.GetHeating()/this.GetCubature();
    }

    public String UsesMoreHeatThan(float maxLevel){
        String useMoreHeat="Id Name\n";
        for (BuildingComponent component : buildingComponents)
            if (component.HeatPerMeter3()>maxLevel)
                useMoreHeat=useMoreHeat+component.getIdx()+" "+component.getName()+"\n";
        return useMoreHeat;
    }
}
