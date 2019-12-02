package Building_Info;

/**
 * Klasa abstrakcyjna definiująca wspólny interfejs i składowe klas opisujących budynki.
 * Jest implementacją komponentu z wzorca projektowego Komponent.
 */
public abstract class BuildingComponent {
    private int idx;
    private String name;

    /**
     * Konstruktor obiektów klasy BuildingComponent.
     * @param idx Identyfikator obiektu. Powinien być unikalny w całym systemie.
     * @param name Nazwa obiektu.
     */
    public BuildingComponent(int idx, String name) {
        this.idx = idx;
        this.name = name;
    }

    /**
     * Zwraca powierzchnię obiektu.
     * @return Powierzchnia obiektu.
     */
    public abstract float GetSurface();

    /**
     * Zwraca moc oświetlenia w obiekcie.
     * @return Moc oświetlenia obiektu.
     */
    public abstract int GetLampWattage();

    /**
     * Zwraca kubaturę obiektu.
     * @return Kubatura obiektu.
     */
    public abstract float GetCubature();

    /**
     * Zwraca zużycie energii na ogrzewanie obiektu.
     * @return Zużycie energii obiektu.
     */
    public abstract float GetHeating();

    /**
     * Zwraca moc oświetlenia w przeliczeniu na jednostkę powierzchni obiektu.
     * @return Moc oświetlenia w przeliczeniu na jednostkę powierzchni obiektu.
     */
    public abstract float LampPerMeter2();

    /**
     * Zwraca zużycie energii na ogrzewanie w przeliczeniu na jednostkę objętości obiektu.
     * @return Zużycie energii w przeliczeniu na jednostkę objętości obiektu.
     */
    public abstract float HeatPerMeter3();

    /**
     * @return Identyfikator obiektu.
     */
    public int getIdx() {
        return idx;
    }

    /**
     * @return Nazwa obiektu
     */
    public String getName() {
        return name;
    }

    /**
     * Wypisuje na ekran informacje oo obiekcie tj.
     * <li>
     *     <ui>Nazwę, </ui>
     *     <ui>Powierzchnię, </ui>
     *     <ui>Objętość, </ui>
     *     <ui>Moc oświetlenia na jednostkę powierzchni, </ui>
     *     <ui>Zużycie energii na ogrzewanie w przeliczeniu na jednostkę objętości.</ui>
     * </li>
     */
    public void printInfo(){
        System.out.println("Name: "+getName());
        System.out.println("Surface: "+GetSurface());
        System.out.println("Cubature: "+GetCubature());
        System.out.println("Lamp per m^2: "+LampPerMeter2());
        System.out.println("Heat per m^3: "+HeatPerMeter3());
    }
}