package Building_Info;

import Utils.JsonParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BuildingCompositeTest {
    BuildingComposite buildingComposite;
    BuildingComposite bigBuildingComposite;
    JsonParser parser;

    @Before
    public void setup(){
        parser = new JsonParser();
        bigBuildingComposite = ((BuildingComposite)(parser.loadJson("test.json")));
        Room mockObject = mock(Room.class);
        when(mockObject.GetSurface()).thenReturn((float) 10);
        when(mockObject.GetLampWattage()).thenReturn(3);
        when(mockObject.GetCubature()).thenReturn((float) 25);
        when(mockObject.GetHeating()).thenReturn((float) 0);
        buildingComposite = new BuildingComposite(1,"1stfloor");
        buildingComposite.AddChild(mockObject);
    }

    @Test
    public void getChildCount() {
        assertEquals(1,buildingComposite.GetChildCount());
    }

    @Test
    public void getSurface() {
        assertEquals(10, buildingComposite.GetSurface(), 0.001);
    }

    @Test
    public void getLampWattage() {
        assertEquals(3, buildingComposite.GetLampWattage());
    }

    @Test
    public void getCubature() {
        assertEquals(25, buildingComposite.GetCubature(), 0.001);
    }

    @Test
    public void getHeating() {
        assertEquals(0, buildingComposite.GetHeating(), 0.001);
    }

    @Test
    public void lampPerMeter2() {
        assertEquals(0.3, buildingComposite.LampPerMeter2(), 0.001);
    }

    @Test
    public void heatPerMeter3() {
        assertEquals(0,buildingComposite.HeatPerMeter3(), 0.001);
    }

    @Test
    public void usesMoreHeatFalse(){
        assertEquals("Id Name\n", buildingComposite.UsesMoreHeatThan(1));
    }

    @Test
    public void usesMoreHeatTrue(){
        assertEquals("Id Name\n", buildingComposite.UsesMoreHeatThan(-1));
    }

    @Test
    public void getLastChild(){
        assertEquals(10, buildingComposite.GetLastChild().GetSurface(), 0.001);
    }

    @Test
    public void getChildCountMultiple() { assertEquals(4, bigBuildingComposite.GetChildCount()); }

    @Test
    public void getSurfaceMultiple() {
        assertEquals(80, bigBuildingComposite.GetSurface(), 0.001);
    }

    @Test
    public void getLampWattageMultiple() {
        assertEquals(80, bigBuildingComposite.GetLampWattage());
    }

    @Test
    public void getCubatureMultiple() {
        assertEquals(80, bigBuildingComposite.GetCubature(), 0.001);
    }

    @Test
    public void getHeatingMultiple() {
        assertEquals(0, bigBuildingComposite.GetHeating(), 0.001);
    }

    @Test
    public void lampPerMeter2Multiple() {
        assertEquals(1, bigBuildingComposite.LampPerMeter2(), 0.001);
    }

    @Test
    public void heatPerMeter3Multiple() {
        assertEquals(0,bigBuildingComposite.HeatPerMeter3(), 0.001);
    }

}