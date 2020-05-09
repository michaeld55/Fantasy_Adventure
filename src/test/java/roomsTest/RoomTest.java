package roomsTest;

import Enemies.Orc;
import Enemies.Summon;
import Players.Barbarian;
import Players.Wizard;
import Resources.Armour;
import Resources.Spell;
import Resources.Staff;
import Resources.Weapon;
import org.junit.Before;
import org.junit.Test;
import rooms.Exit;
import rooms.Room;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RoomTest {

    private Weapon axe;
    private Armour basic;
    private Orc arkail;
    private Room room;
    private Barbarian conan;
    private Staff staff;
    private Spell attack;
    private Spell heal;
    private Wizard merlin;
    private Weapon claw;
    private Armour hide;
    private Summon imp;

    @Before
    public void before(){
        axe = new Weapon("axe", 30, 10);
        basic = new Armour("Leather", 5, 10);
        arkail = new Orc("Arkail", 40, axe, basic);
        room = new Room();
        conan = new Barbarian("Conan",50, axe, basic);
        staff = new Staff("Sidhe", 30, 10, 10);
        attack = new Spell("attack", 30, 0, 1);
        heal = new Spell("heal", 0, 20, 1);
        merlin = new Wizard("Merlin", 30, staff);
        claw = new Weapon("Claw", 5, 0);
        hide = new Armour("Hide", 5, 0);
        imp = new Summon("Imp", 10, claw, hide);
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
    public void canBeCompleted(){
        Armour chain = new Armour("Chain mail", 10, 20);
        room.addEnemy(arkail);
        room.addTreasure(chain);
        room.encounter(conan);
        assertEquals(chain.getArmourPoint(), conan.getArmour().getArmourPoint());
        assertEquals(10, conan.getPouch());
        assertTrue(room.isComplete());
    }

    @Test
    public void canBeFailed(){
        Armour uber = new Armour("Uber", 100, 2000);
        arkail.setArmour(uber);
        room.addEnemy(arkail);
        room.encounter(conan);

        assertEquals(0, conan.getHealth());
        assertFalse(room.isComplete());
    }

    @Test
    public void canBeCompleteByWizard(){
        room.addEnemy(arkail);
        room.addTreasure(heal);
        merlin.addSpell(attack);
        merlin.addSpell(attack);
        merlin.addSpell(attack);
        merlin.setSummon(imp);
        room.encounter(merlin);

        assertEquals(0, arkail.getHealth());
        assertTrue(merlin.getSpells().contains(heal));
        assertTrue(room.isComplete());
    }

    @Test
    public void testMakeRoom(){
        int test = 10;
        ArrayList<Room> testRooms = new ArrayList<Room>();
        while (test > 0){
            room.create();
            testRooms.add(room);
            test --;
        }

        assertEquals(10, testRooms.size());

    }

    @Test
    public void testSummonCanDie(){
        claw = new Weapon("Claw", 5, 0);
        hide = new Armour("Hide", 5, 0);
        imp = new Summon("Imp", 10, claw, hide);

        room.addEnemy(imp);
        room.encounter(conan);

        assertEquals(0, imp.getHealth());
        assertTrue(room.isComplete());
    }
}
