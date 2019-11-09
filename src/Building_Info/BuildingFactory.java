package Building_Info;

public class BuildingFactory {
    BuildingComposite constructedComponent;
    //TODO: when loading buildings from json, make sure idx is set to such a value that no two building will have the same idx
    int idx = 0;

    public BuildingFactory(String name) {
        constructedComponent= new BuildingComposite(idx, name);
    }

    public void Reset(String name){
        constructedComponent = new BuildingComposite(idx, name);
    }

    public void AddFloor(String name){
        idx++;
        constructedComponent.AddChild(new BuildingComposite(idx, name));
    }

    public void AddRoom(String name, float surface, int lampWattage, float cubature){
        idx++;
        if(constructedComponent.GetChildCount() > 0){
            BuildingComposite Floor = (BuildingComposite) constructedComponent.GetLastChild();
            Floor.AddChild(new Room(idx, name, surface, lampWattage, cubature));
        }
        else{
            System.out.println("Room not created: A building without floors, cant have any rooms.");
        }
    }

    public BuildingComponent GetResult(){
        return constructedComponent;
    }

    public static BuildingComponent GetExamplaryBuilding() {
        BuildingFactory factory = new BuildingFactory("Building");

        factory.AddFloor("Floor1");
        factory.AddRoom("Room11", 10, 4, 10);
        factory.AddRoom("Room12", 8, 6, 7);
        factory.AddRoom("Room13", 8, 6, 7);

        factory.AddFloor("Floor2");
        factory.AddRoom("Room21", 14, 6, 7);
        factory.AddRoom("Room22", 14, 6,7);

        factory.AddFloor("Floor3");
        factory.AddRoom("Room31", 14, 6, 7);
        factory.AddRoom("Room32", 8, 6,7);
        factory.AddRoom("Room33", 4, 6,7);

        return factory.GetResult();
    }
}
