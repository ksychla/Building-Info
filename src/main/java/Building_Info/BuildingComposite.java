package Building_Info;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasa do reprezentacji, budynków i ich pięter.
 * Jest implementacją kompozytu z wzorca projektowego Komponent.
 */
public class BuildingComposite extends BuildingComponent {

    private ArrayList<BuildingComponent> buildingComponents;

    /**
     * Konstruktor obiektów klasy BuildingComposite
     * @param idx Unikalny identyfikator obiektu.
     * @param name Nazwa obiektu.
     */
    public BuildingComposite(int idx, String name) {
        super(idx, name);
            buildingComponents = new ArrayList<>();
    }

    /**
     * Przechodzi hierarchię w poszukiwaniu obiektu o podanym identyfikatorze.
     * @param id Identyfikator poszukiwanego obiektu
     * @return Poszukiwany obiekt lub null w przpyadku gdy nie został on odnaleziony.
     */
    public BuildingComponent getComponentById(int id){
        for(BuildingComponent component : buildingComponents){
            if(component.getIdx() == id){
                return component;
            }
        }
        return null;
    }

    /**
     * @return Zwraca ilość bezpośrednich składowych.
     */
    public int GetChildCount(){
        return buildingComponents.size();
    }

    /**
     * @return Zwraca ostatnią bezpośrednią składową.
     */
    BuildingComponent GetLastChild(){
        return buildingComponents.get(buildingComponents.size() - 1);
    }

    /**
     * @param buildingComponent Nowa składowa obiektu, będąca pochodną klasy BuildingComponent.
     */
    public void AddChild(BuildingComponent buildingComponent) {
        buildingComponents.add(buildingComponent);
    }


    /**
     * {@inheritDoc}
     * Przez powierzchnię obiektu, w tym wypadku rozumie się sumę powierzchni jego składowych.
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
     * {@inheritDoc}
     * Przez moc oświetlenia obiektu, w tym wypadku rozumie się sumę mocy oświetlenia jego składowych.
     */
    @Override
    public  int GetLampWattage(){
        int sum=0;
        for (BuildingComponent component : buildingComponents)
             sum+=component.GetLampWattage();
        return sum;
    }

    /**
     * {@inheritDoc}
     * Przez kubaturę obiektu, w tym wypadku rozumie się sumę kubatur jego składowych.
     */
    @Override
    public  float GetCubature(){
        float sum=0;
        for (BuildingComponent component : buildingComponents)
            sum+=component.GetCubature();
        return sum;
    }

    /**
     * {@inheritDoc}
     * Przez zużycie energii na ogrzewanie obiektu, w tym wypadku rozumie się sumę zużyć energii jego składowych.
     */
    @Override
    public float GetHeating() {
        float sum=0;
        for (BuildingComponent component : buildingComponents)
            sum+=component.GetHeating();
        return sum;
    }

    /**
     * {@inheritDoc}
     * Przez powierzchnię obiektu, w tym wypadku rozumie się sumę powierzchni jego składowych.
     * Przez moc oświetlenia obiektu, w tym wypadku rozumie się sumę mocy oświetlenia jego składowych.
     */
    public  float LampPerMeter2(){
        return this.GetLampWattage()/this.GetSurface();
    }

    /**
     * {@inheritDoc}
     * Przez zużycie energii na ogrzewanie obiektu, w tym wypadku rozumie się sumę zużyć energii jego składowych.
     * Przez kubaturę obiektu, w tym wypadku rozumie się sumę kubatur jego składowych.
     */
    @Override
    public float HeatPerMeter3() {
        return this.GetHeating()/this.GetCubature();
    }

    /**
     * Wyszukuje składowe obiektu których zużycie energii na ogrzewanie w jednostcę obiętości przekracza podany limit.
     * @param maxLevel limit żużycia energii
     * @return Łańcuch znaków.
     * Każda linia zawiera identyfikator i nazwę składowej przekrazcającej limit.
     * Linie oddzielane są pojedyńczym znakiem końca lini.
     */
    public String UsesMoreHeatThan(float maxLevel){
        String useMoreHeat="Id Name\n";
        for (BuildingComponent component : buildingComponents)
            if (component.HeatPerMeter3()>maxLevel)
                useMoreHeat=useMoreHeat+component.getIdx()+" "+component.getName()+"\n";
        return useMoreHeat;
    }
}
