package game;

public class RoomManager {
	
	// a constant array that holds

    //all valid command words

   private static final String[] validCommands = {

       "go", "quit", "help",

       "look","eat","back",

       "stackBack"

   };

   /**

    * Constructor - initialize the command words.

    */

   public RoomManager()

   {

       // nothing to do at the moment...

   }

   public boolean isCommand(String aString)

   {

       for(int i = 0; i < validCommands.length; i++) {

           if(validCommands[i].equals(aString))

               return true;

       }

       // if we get here, the string was not

       //found in the commands

       return false;

   }

   /**Part 2:

    * Print all valid commands to System.out.

    *"getCommandList" and have it return a String

    *instead of printing the commands.*/

   public String getCommandList()

   {

   String reslut="";

       for(String command: validCommands) {

       reslut +=command + " ";

       }

       return reslut+"\n";

   }

}
