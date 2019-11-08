package Building_Info;

public class Room extends BuildingComponent{
    private float surface;
    private int lampWattage;
    private int cubature;

    public Room(int idx, String name, float surface, int lampWattage, int cubature) {
        super(idx, name);
        this.surface = surface;
        this.lampWattage = lampWattage;
        this.cubature = cubature;
    }

    @Override
    public void GetSurface() {
        System.out.println(super.getName() + " GetSurface");
    }
}
