package Building_Info;

public class Room extends BuildingComponent{
    private float surface;
    private int lampWattage;
    private float cubature;
    private float heating;

    public Room(int idx, String name, float surface, int lampWattage, int cubature) {
        super(idx, name);
        this.surface = surface;
        this.lampWattage = lampWattage;
        this.cubature = cubature;
        this.heating=0; //next step: set heating
    }

    /**
     *Calculates the surface of a room
     * @return surface
     */
    @Override
    public float GetSurface() {
        return surface;
    }

    /**
     *Calculates the lamp wattage of a room
     * @return wattage
     */
    public int GetLampWattage(){
        return lampWattage;
    }

    /**
     *Calculates the cubature of a room
     * @return cubature
     */
    public float GetCubature(){
        return cubature;
    }

    /**
     *Calculates the heating of a room
     * @return heating
     */
    public float GetHeating(){
        return heating;
    }

    /**
     *Calculates the lamp wattage per square meter of a room
     * @return wattage/m2
     */
    public float LampPerMeter2(){
        return lampWattage/surface;
    }

    /**
     *Calculates the heating per cubic meter of a room
     * @return heating/m3
     */
    public float HeatPerMeter3(){
        return heating/cubature;
    }
    
    public String GetInfo(){
        return "No. "+getIdx()+" name "+getName()+" surface "+surface+" cubature "+cubature+" lampWattage "+lampWattage;
    }
}
