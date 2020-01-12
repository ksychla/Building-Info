package Building_Info;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {
    Room room;

@Before
public void setup(){
    room = new Room(1, "Sleeproom", 10, 3,25, 10);
}

    @Test
    public void getSurface() {
    assertEquals(10, room.GetSurface(), 0.001);
    }

    @Test
    public void getLampWattage() {
    assertEquals(3, room.GetLampWattage());
    }

    @Test
    public void getCubature() {
    assertEquals(25, room.GetCubature(), 0.001);
    }

    @Test
    public void getHeating() {
    assertEquals(10, room.GetHeating(), 0.001);
    }

    @Test
    public void lampPerMeter2() {
    assertEquals(0.3, room.LampPerMeter2(), 0.001);
    }

    @Test
    public void heatPerMeter3() {
    assertEquals(0.4, room.HeatPerMeter3(), 0.001);
    }

    @Test
    public void getInfo() { assertEquals("No. 1 name Sleeproom surface 10.0 cubature 25.0 lampWattage 3", room.GetInfo());}
}