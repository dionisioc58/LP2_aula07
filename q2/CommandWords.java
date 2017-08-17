/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
import java.util.HashMap;

public class CommandWords
{
	/**
	 * Representações de todas as palavras de comando válidas para o jogo
	 * junto com uma string
	 */
	public enum CommandWord
	{
		//Define o comando e sua string de chamada pelo usuário
		GO("go"), QUIT("quit"), HELP("help"), OLHAR("olhar"), UNKNOWN("?");
		//A palavra de comando
		private String commandWord;
		
		/**
		 * Inicializa com a palavra de comando correspondente.
		 * @param commandWord A palavra de comando.
		 */
		CommandWord(String commandWord)
		{
			this.commandWord = commandWord;
		}

		/**
		 * @return A palavra de comando como uma string.
		 */
		public String toString()
		{
			return commandWord;
		}
	}	

	private HashMap<String, CommandWord> validCommands;
	    
	// a constant array that holds all valid command words
    //private static final String[] validCommands = {
    //    "go", "quit", "help", "olhar"
    //};

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
		validCommands = new HashMap<String, CommandWord>();
		for(CommandWord command : CommandWord.values()) {
			if(command != CommandWord.UNKNOWN) {
				validCommands.put(command.toString(), command);
			}
		}
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
		for(String valor : validCommands.keySet()) {
            if(valor.equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
	/**
	 * Imprimir todos os comando válidos para System
	 */
	public void showAll() {
		for(String valor : validCommands.keySet()) {
			System.out.print(valor + " ");
		}
		System.out.println();
	}
}
