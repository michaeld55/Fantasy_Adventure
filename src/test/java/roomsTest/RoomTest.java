package roomsTest;

import org.junit.Before;
import org.junit.Test;
import rooms.Exit;
import rooms.Room;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RoomTest {

    private Room room;

    @Before
    public void before(){
        room = new Room();
    }

    @Test
    public void canAddExit(){
        room.addExit(Exit.NORTH);
        assertEquals(Exit.NORTH, room.getExit(Exit.NORTH));
        assertNull(room.getExit(Exit.SOUTH));
    }
}
