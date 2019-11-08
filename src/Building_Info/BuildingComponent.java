package Building_Info;

public abstract class BuildingComponent {
    private int idx;
    private String name;

    public BuildingComponent(int idx, String name) {
        this.idx = idx;
        this.name = name;
    }

    public abstract float GetSurface();
    public abstract int GetLampWattage();
    public abstract float GetCubature();
    public abstract float GetHeating();
    public abstract float LampPerMeter2();
    public abstract float HeatPerMeter3();


    public int getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }

    public static BuildingComponent GetExamplaryBuilding() {
        BuildingComposite budynek = new BuildingComposite(1, "Budynek");
        BuildingComposite pietro1 = new BuildingComposite(2, "Pietro1");
        pietro1.AddChild(new Room(3, "Poko1", 10, 10, 10));
        pietro1.AddChild(new Room(4, "Poko1", 10, 10, 10));

        BuildingComposite pietro2 = new BuildingComposite(5, "Pietro2");
        pietro2.AddChild(new Room(6, "Poko1", 10, 10, 10));
        pietro2.AddChild(new Room(7, "Poko1", 10, 10, 10));

        BuildingComposite pietro3 = new BuildingComposite(10, "Pietro3");
        pietro3.AddChild(new Room(9, "Poko1", 10, 10, 10));
        pietro3.AddChild(new Room(10, "Poko1", 10, 10, 10));

        BuildingComposite pietro4 = new BuildingComposite(11, "Pietro4");
        pietro4.AddChild(new Room(12, "Poko1", 10, 10, 10));
        pietro4.AddChild(new Room(13, "Poko1", 10, 10, 10));

        budynek.AddChild(pietro1);
        budynek.AddChild(pietro2);
        budynek.AddChild(pietro3);
        budynek.AddChild(pietro4);

        return budynek;
    }
}