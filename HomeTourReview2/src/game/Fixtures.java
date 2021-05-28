package game;

import java.util.Stack;

public class Fixtures {
	
	 private Parser parser;

     private Room currentRoom;

     private Stack<Room> route;

     /**

     * initializing the game internal map.

     */

     public Fixtures()

     {

          createRooms();

          parser = new Parser();

          route = new Stack<Room>();

     }

     /**

     * Create all the rooms and link their exits together.

     */

     private void createRooms()

     {

          Room parking, livingroom, dinningroom, kitchen, balcony;

          // create the rooms

          parking = new Room("You are at the parking lot. Outside the main entrance of the house of tons of funs\n");

          livingroom = new Room(" You are in the Living room. a comfy place with sofas, chairs, Tv and somme bookshelves");

          dinningroom = new Room("You are in the dinning room.A lounge with a big table decorated with flours along 8 medieval chairs");

          kitchen = new Room("You are in the Kitchen. An area designed with stoves, sinks, and refridgerator where dishes are pile up");

          balcony = new Room("You are in the balcony. A platform enclosed by a wall on the outside of the house with access from upper-floor window");

          // Part 3:

          // Add Items to rooms

          livingroom.addItem(new Item("Tv", 3.0));

          balcony.addItem(new Item("comfy Chairs", 5.0));

          balcony.addItem(new Item("pots of flours", 15.0));

          kitchen.addItem(new Item("Dishes", 3.0));

          kitchen.addItem(new Item("Sink", 0.5));

          // initialize room exits

          parking.setExit("east", livingroom);

          parking.setExit("south", kitchen);

          parking.setExit("west", dinningroom);

          livingroom.setExit("west", parking);

          dinningroom.setExit("east", parking);

          kitchen.setExit("north", parking);

          kitchen.setExit("east", balcony);

          balcony.setExit("west", kitchen);

          currentRoom = parking; // start game outside

     }

     /**

     * Main play routine. Loops until end of play.

     */

     public void play()

     {

          printWelcome();

          // Enter the main command loop. Here we repeatedly

          //read commands and execute them until the game is over.

          boolean finished = false;

          while (!finished)

          {

              Player player = parser.getCommand();

              finished = processCommand(player);

          }

          System.out.println("Thank you for playing. Good bye.");

     }

     /**

     * Print out the opening message for the player.

     */

     private void printWelcome()

     {

          System.out.println();

          System.out.println("Welcome to my world of tons of funs!!\n");

          System.out.println("Great adventure game is about to begin.");

          System.out.println("1)Type 'help' if you need help");

          System.out.println();
          
          System.out.println("**Here your instructions**");
          System.out.println("1) go east\n"
          		+ "2) go west\n"
          		+ "3) go north\n"
          		+ "4) go south");
          System.out.println("You can also perform action like:\n");
          System.out.println("1)eat if you have eaten\n"
          		+ "2)look to check your surroundings if you're lost \n"
          		+ "3)back if you want to go back to your previous location\n"
          		+ "4)stack if you stack books in the library");

          System.out.println(currentRoom.getLongDescription());

     }

/* Given a command, process (that is: execute) the command.

     *

     * @param command

     * The command to be processed

     * @return true If the command ends the game, false otherwise

     */

     private boolean processCommand(Player player)

     {

          boolean wantToQuit = false;

          if (player.isUnknown())

          {

              System.out.println("I don't get it at all...");

              return false;

          }

          String commandWord = player.getCommandWord();

          if (commandWord.equals("help"))

          {

              printHelp();

          }

          else if (commandWord.equals("go"))

          {

              goRoom(player);

          }

          else if (commandWord.equals("quit"))

          {

              wantToQuit = quit(player);

          }

          //part 1: add look and eat commands

          else if (commandWord.equals("look"))

          {

              lookRoom(player);

          }

          else if (commandWord.equals("eat"))

          {

              eat(player);

          }

          //Part 4: add BACK command

          else if (commandWord.equals("back"))

          {

              back(player);

          }

          //Part 6:add Stackback command

          else if (commandWord.equals("stackback"))

          {

              stackback(player);

          }

          // else command not recognized.

          return wantToQuit;

     }

     // implementations of user commands:

     /**

     * Print out some help information.

     * Here we print a cryptic message and a list

     * of the command words.

     */

     private void printHelp()

     {

          System.out.println("You are lost.");

          System.out.println("Look around the room.");

          System.out.println();

          System.out.println("Type any command in words:");

          // Part 2: Modified

          System.out.println(parser.getCommands());

     }

     /**

     * Try to go to one direction. If there is an exit,

     * enter the new room,

     * otherwise print an error message.

     *

     * @param player

     * The command to be processed

     */

     private void goRoom(Player player)

     {

          if (!player.hasSecondWord())

          {

              // if there is no second word,

              //we don't know where to go...

              System.out.println("Go where?");

              return;

          }

          String direction = player.getSecondWord();

          // Try to leave current room.

          Room nextRoom = currentRoom.getExit(direction);

          if (nextRoom == null)

          {

              System.out.println("There is no door!");

          }

          else

          {

              route.push(currentRoom);

              currentRoom = nextRoom;

              System.out.println(currentRoom.getLongDescription());

          }

     }

     /*

     * Part 1: Two new commands: "look" and "eat"

     */

     void lookRoom(Player player)

     {// "look" method to the "Game" class

          if (player.hasSecondWord())

          {

              // if there is no second word,

              //we don't know where to go...

              System.out.println("Look what?");

              return;

          }

          System.out.println(currentRoom.getLongDescription());

     }

     //eat command.

     void eat(Player player)

     {

          if (player.hasSecondWord())

          {

              // if there is no second word,

              //we don't know where to go...

              System.out.println("eat what?");

              return;

          }

          System.out.println("you have eaten");

     }

     //back command 

     void back(Player player)

     {

          if (player.hasSecondWord())

          {

              // if there is no second word,

              //we don't know where to go...

              System.out.println("Back what?");

              return;

          }

          // Try to leave current room.

          Room nextRoom = route.pop();

          if (nextRoom == null)

          {

              System.out.println("you cannot go back,"+

                                           "There is the begining room!");

          }

          else

          {

              // Store the currentRoom

              Room tt = currentRoom;

              // Go to the previous room

              currentRoom = nextRoom;

              // Store the previous current room

              route.push(tt);

              // Get currentRoom description

              System.out.println(currentRoom.getLongDescription());

          }

     }

     //stack back command
     
     void stackback(Player player)

     {

          if (player.hasSecondWord())

          {

              // if there is no second word,

              //we don't know where to go...

              System.out.println("Back what?");

              return;

          }

          // Try to leave current room.

          Room nextRoom = route.pop();

          if (nextRoom == null)

          {

              System.out.println("you cannot go back,"+

                                           "There is the begining room!");

          }

          else

          {

              /// Store the previous current room

              route.push(currentRoom);

              currentRoom = nextRoom;

              System.out.println("you have gone back");

          }

     }

     /**

     * "Quit" was entered. Check the rest of the

     * command to see whether we really

     * quit the game.

     *

     * @param player

     *The command to be processed

     * @return true, if this command quits the game,

     * false otherwise

     */

     private boolean quit(Player player)

     {

          if (player.hasSecondWord())

          {

              System.out.println("Quit what?");

              return false;

          }

          else

          {

              return true; // signal that we want to quit

          }

     }

}
