package game;

import java.util.Scanner;
import java.util.StringTokenizer;


public class Parser {
	
	//holds all valid command words

    private RoomManager commands;

    // source of command input

    private Scanner reader;        

    /**

     * Create a parser to read from

     * the terminal window.

     */

    public Parser()

    {

        commands = new RoomManager();

        reader = new Scanner(System.in);

    }

    /**

     * Get the command from the user.

     *

     * @return The next command from the user

     */

    public Player getCommand()

    {

   // will hold the full input line

        String inputLine;  

        String word1 = null;

        String word2 = null;

        // print prompt

        System.out.print("> ");   

        inputLine = reader.nextLine();

        // Find up to two words on the line.

        Scanner tokenizer = new Scanner(inputLine);

        if(tokenizer.hasNext()) {

            word1 = tokenizer.next();// get first word

            if(tokenizer.hasNext()) {

                word2 = tokenizer.next(); // get second word

                // note: we just ignore the rest of the input line.

            }

        }

        // Now check whether this word is known.

        //If so, create a command with it.

        //If not, create a "null" command (for unknown command).

        if(commands.isCommand(word1)) {

            return new Player(word1, word2);

        }

        else {

            return new Player(null, word2);

        }

    }

    /**Part 2

     * Print out a list of valid command words.

     * Method "showCommands" should become

     * "getCommands",

     * and again return a String.

     */

    public String getCommands()

    {

        return commands.getCommandList();

    }

}
