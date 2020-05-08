package roomsTest;

import Enemies.Orc;
import Players.Barbarian;
import Resources.Armour;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;
import rooms.Exit;
import rooms.Room;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RoomTest {

    private Weapon axe;
    private Armour basic;
    private Orc arkail;
    private Room room;
    private Barbarian conan;

    @Before
    public void before(){
        axe = new Weapon("axe", 30);
        basic = new Armour("Leather", 5);
        arkail = new Orc("Arkail", 40, axe, basic);
        room = new Room();
        conan = new Barbarian("Conan",50, axe, basic);
    }

    @Test
    public void hasBasicInfoSetToNull(){
        assertNull(room.getEnemy());
        assertNull(room.getTreasure());
        assertNull(room.getExit(Exit.WEST));
    }

    @Test
    public void canAddExit(){
        room.addExit(Exit.NORTH);
        assertEquals(Exit.NORTH, room.getExit(Exit.NORTH));
        assertNull(room.getExit(Exit.SOUTH));
    }

    @Test
    public void canHaveEnemy(){
        room.addEnemy(arkail);
        assertEquals(arkail, room.getEnemy());
    }

    @Test
    public void canHaveTreasure(){
        room.addTreasure(basic);
        assertEquals(basic, room.getTreasure());
    }

    @Test
    public void canBeComplete(){
        Armour chain = new Armour("Chain mail", 10);
        room.addEnemy(arkail);
        room.addTreasure(chain);
        room.encounter(conan);
        arkail.setHealth(0);

    }
}
