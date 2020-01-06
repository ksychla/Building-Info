package Building_Info;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BuildingCompositeTest {
    BuildingComposite buildingComposite;

    @Before
    public void setup(){
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

}