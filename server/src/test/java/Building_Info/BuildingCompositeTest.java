package Building_Info;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingCompositeTest {
    BuildingComposite buildingComposite;

    @Before
    public void setup(){
        Room mockObject=mock(Room);
        when(mockObject.getSurface()).thenReturn(10);
        when(mockObject.getLampWattage()).thenReturn(3);
        when(mockObject.getCubature()).thenReturn(25);
        when(mockObject.getHeating()).thenReturn(0);
        buildingComposite = new BuildingComposite(1,"1stfloor");
        buildingComposite.addChild(mockObject);
    }

    @Test
    public void getChildCount() {
        assertEquals(1,buildingComposite.getChildCount());
    }

    @Test
    public void getSurface() {
        assertEquals(10, buildingComposite.getSurface());
    }

    @Test
    public void getLampWattage() {
        assertEquals(3, buildingComposite.getLampWattage());
    }

    @Test
    public void getCubature() {
        assertEquals(25, buildingComposite.getCubature());
    }

    @Test
    public void getHeating() {
        assertEquals(0, buildingComposite.getHeating());
    }

    @Test
    public void lampPerMeter2() {
        assertEquals(0.3, buildingComposite.lampPerMeter2());
    }

    @Test
    public void heatPerMeter3() {
        assertEquals(0,buildingComposite.heatPerMeter3());
    }

}