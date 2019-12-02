package Building_Info;

/**
 * Klasa odpowiadająca za proces konstruuowania hierarchii budynków.
 * Implmentuje budowniczego z wzorca Builder.
 * Pojedyńczy bowniczy nadaje obiektom unikalne identydfikatory w obrębie konstruoowanych przez niego budynków.
 */
public class BuildingBuilder {
    BuildingComposite constructedComponent;
    //TODO: when loading buildings from json, make sure idx is set to such a value that no two building will have the same idx
    int idx = 0;

    /**
     * Tworzy instancję budowniczego.
     * Po utworzeniu budowniczy jest gotowy do wykonywania kolejnych kroków składani budynku.
     * @param name Nazwa konstruuowanych budynków.
     */
    public BuildingBuilder() {
        constructedComponent= new BuildingComposite(idx, "temp");
    }

    /**
     * Resetuje konstruoowany budynek do postaci sprzed wykonania jakichkolwiek kroków.
     * @param name Nowa nazwa konstruuwanych budynków.
     */
    public void Reset(){
        constructedComponent = new BuildingComposite(idx, "temp");
    }

    /**
     * Dodaje do budynku nowe piętro.
     * @param name Nazwa nowego piętra.
     */
    public void AddFloor(String name){
        idx++;
        constructedComponent.AddChild(new BuildingComposite(idx, name));
    }

    /**
     * Dodaje pomieszczenia do ostatnio dodanego piętra.
     * Jeśli nie dodano żadnego piętra, zamieszcza komunikat i ignoruje polecenie.
     * @param name Nazwa pomieszczenia.
     * @param surface Powierzchnia pomieszczenia.
     * @param lampWattage Moc oświetlenia pomieszczenia.
     * @param cubature Obiętość pomieszczenia.
     */
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

    /**
     * Zwraca stworzony budynek. Budowniczy wraca do stanu sprzed wykonania jakichkolwiek kroków.
     * @param name Nazwa stworzonego budynku.
     * @return Stworzony budynek.
     */
    public BuildingComponent GetResult(String name){
        BuildingComponent builidng = constructedComponent;
        Reset();
        return builidng;
    }

    /**
     * Przykład użycia obiektu BuildingBuilder do utworzenia budynku.
     * @return Przykładowy budynek.
     */
    public static BuildingComponent GetExamplaryBuilding() {
        BuildingBuilder factory = new BuildingBuilder();

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

        return factory.GetResult("Building");
    }
}
