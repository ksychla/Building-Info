package Building_Info;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {
    Room room;

@Before
public void setup(){
    room=new Room(1, "Sleeproom", 10, 3,25);
}

    @Test
    public void getSurface() {
    assertEquals(10, room.GetSurface());
    }

    @Test
    public void getLampWattage() {
    assertEquals(3, room.GetLampWattage());
    }

    @Test
    public void getCubature() {
    assertEquals(25, room.GetCubature());
    }

    @Test
    public void getHeating() {
    assertEquals(0, room.GetHeating());
    }

    @Test
    public void lampPerMeter2() {
    assertEquals(0.3, room.LampPerMeter2());
    }

    @Test
    public void heatPerMeter3() {
    assertEquals(0, room.HeatPerMeter3());
    }
}