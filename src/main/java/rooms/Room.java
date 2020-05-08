package rooms;

import java.util.ArrayList;

public class Room {

    private ArrayList<Exit> exits;

    public Room() {
        exits = new ArrayList<Exit>();
    }

    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    public Exit getExit(Exit exit) {
        if(exits.contains(exit)) return exit;
        return null;
    }
}
