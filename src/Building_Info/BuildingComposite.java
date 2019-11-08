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

    @Override
    public void GetSurface() {
        System.out.println(super.getName() + " GetSurface:");
        for (BuildingComponent component : buildingComponents) {
            component.GetSurface();
        }
    }
}
