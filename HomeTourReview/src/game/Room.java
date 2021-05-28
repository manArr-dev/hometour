package game;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Room {
	
	 private String description;

	    // stores exits of this room.

	    private HashMap<String, Room> exits;       

	    private ArrayList<Item> items;

	    /**

	     * Create a room described "description".

	     * Initially, it has no exits. "description"

	     * is something like "a kitchen" or

	     * "an open court yard".

	     * @param description The room's description.

	     */

	    public Room(String description)

	    {

	        this.description = description;

	        exits = new HashMap<String, Room>();

	        items=new ArrayList<Item>();

	    }

	    /*Part 3:

	     * a method to add an item to a room

	     */

	    void addItem(Item item)

	    {   

	    int index =items.size();

	    items.add(index,item);

	    }

	    /**

	     * Define an exit from this room.

	     *

	     * @param direction The direction of the exit

	     * @param neighbour The room to which the exit leads

	     */

	    public void setExit(String direction, Room neighbour)

	    {

	        exits.put(direction, neighbour);

	    }

	    /**

	     * Returns a short description of the room,

	     * i.e. the one that

	     * was defined in the constructor

	     *

	     * @return The short description of the room

	     */

	    public String getShortDescription()

	    {

	        return description;

	    }

	    /**

	     * Return a long description of the room

	     * in the form: You are in the kitchen.

	     *     Exits: north west     *   

	     * @return A long description of this room

	     */

	    public String getLongDescription()

	    {

	    String itemDesc="Items in the room are: \n";

	   

	    for(int i=0;i<items.size();i++){

	          Item item =items.get(i);

	          itemDesc+=item;

	    }

	         

	        return "You are " + description + ".\n"

	                    +itemDesc+ getExitString();

	    }

	    private String getExitString()

	    {

	        String returnString = "Exits:";

	        Set<String> keys = exits.keySet();

	        for(String exit : keys) {

	            returnString += " " + exit;

	        }

	        return returnString;

	    }

	   

	    public Room getExit(String direction)

	    {

	        return exits.get(direction);

	    }

}
