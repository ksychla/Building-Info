package Building_Info;

/**
 * Klasa do reprezentacji pokoi.
 * Jest implementacją Liścia z wzorca Komponent.
 */
public class Room extends BuildingComponent{
    private float surface;
    private int lampWattage;
    private float cubature;
    private float heating;

    /**
     * Konstruktor obiektów klasy Room
     * @param idx Unikalny identyfikator obiektu.
     * @param name Nazwa obiektu.
     * @param surface Powierzchnia
     * @param lampWattage Moc oświetlenia
     * @param cubature Objętość
     */
    public Room(int idx, String name, float surface, int lampWattage, float cubature, float heating) {
        super(idx, name);
        this.surface = surface;
        this.lampWattage = lampWattage;
        this.cubature = cubature;
        this.heating = heating;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public float GetSurface() {
        return surface;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int GetLampWattage(){
        return lampWattage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float GetCubature(){
        return cubature;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float GetHeating(){
        return heating;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float LampPerMeter2(){
        return lampWattage/surface;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float HeatPerMeter3(){
        return heating/cubature;
    }

    /**
     * {@inheritDoc}
     */
    public String GetInfo(){
        return "No. "+getIdx()+" name "+getName()+" surface "+surface+" cubature "+cubature+" lampWattage "+lampWattage;
    }
}
