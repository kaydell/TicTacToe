/**
 * This class is an abstract class that allows the code to have any combination of HumanPlayer or ComputerPlayer.
 * 
 * @author kaydell
 *
 */
public abstract class Player {

	// instance variables
	private Game game;
	private char letter;

	// constructor
	public Player(Game game, char letter) {
		this.game = game;
		this.letter = letter;
	}
	
	/**
	 * This class is abstract so that HumanPlayer and ComputerPlayer, which extend Player, can implement different versions
	 * of the getMove() method.  The HumanPlayer's getMove() method merely asks the user to enter a move.  The ComputerPlayer's
	 * getMove() method calculates what the computer thinks is the best move.
	 * 
	 * @return Returns the move that the player wants to make.
	 */
	public abstract Move getMove();

	public Game getGame() {
		return game;
	}
	
	public char getLetter() {
		return letter;
	}

}
