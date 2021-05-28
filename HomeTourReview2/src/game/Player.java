package game;

public class Player {
	
	private String commandWord;

    private String secondWord;

   

    public Player(String firstWord, String secondWord)

    {

        commandWord = firstWord;

        this.secondWord = secondWord;

    }

    public String getCommandWord()

    {

        return commandWord;

    }

    public String getSecondWord()

    {

        return secondWord;

    }

    /**

     * Returns true if the command is unknown.

     *

     * @return true if this command was not

     * understood, false otherwise

     */

    public boolean isUnknown()

    {

        return (commandWord == null);

    }

    /**

     * Returns true if the command has a second word.

     *

     * @return true if the command has a second word,

     * false otherwise

     */

    public boolean hasSecondWord()

    {

        return (secondWord != null);

    }

}
