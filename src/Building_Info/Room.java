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

    /**
     *Zwraca powierzchnię pokoju
     * @return powierzchnia
     */
    @Override
    public float GetSurface() {
        return surface;
    }

    /**
     *Zwraca oświetlenie pokoju
     * @return waty
     */
    public int GetLampWattage(){
        return lampWattage;
    }

    /**
     *Zwraca kubaturę pokoju
     * @return kubatura
     */
    public float GetCubature(){
        return cubature;
    }

    /**
     *Zwraca ilość ciepła potrzebną do ogrzania pokoju
     * @return ciepło
     */
    public float GetHeating(){
        return heating;
    }

    /**
     *Oblicza ilość oświetlenia w przeliczeniu na m3
     * @return wat/m2
     */
    public float LampPerMeter2(){
        return lampWattage/surface;
    }

    /**
     *Oblicza ilość ciepła do ogrzania w przeliczeniu na m3
     * @return ciepło/m3
     */
    public float HeatPerMeter3(){
        return heating/cubature;
    }
    
    public String GetInfo(){
        return "No. "+getIdx()+" name "+getName()+" surface "+surface+" cubature "+cubature+" lampWattage "+lampWattage;
    }
}
