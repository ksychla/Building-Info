package Building_Info;

public class Room extends BuildingComponent{
    private float surface;
    private int lampWattage;
    private float cubature;
    private float heating;

    public Room(int idx, String name, float surface, int lampWattage, float cubature) {
        super(idx, name);
        this.surface = surface;
        this.lampWattage = lampWattage;
        this.cubature = cubature;
        this.heating=0; //next step: set heating
    }

    @Override
    public float GetSurface() {
        return surface;
    }

    public int GetLampWattage(){
        return lampWattage;
    }

    public float GetCubature(){
        return cubature;
    }

    public float GetHeating(){
        return heating;
    }

    public float LampPerMeter2(){
        return lampWattage/surface;
    }

    public float HeatPerMeter3(){
        return heating/cubature;
    }

    public String GetInfo(){
        return "No. "+getIdx()+" name "+getName()+" surface "+surface+" cubature "+cubature+" lampWattage "+lampWattage;
    }
}
