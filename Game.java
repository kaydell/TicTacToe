/**
 * This class is used to play one game of Tic-Tac-Toe.  For each new game, create a new Game object.
 * 
 * @author kaydell
 *
 */
public class Game
{
	// instance variables
	private Player player1;
	private Player player2;
	private Board board;

	/**
	 *  Call this constructor to start a new game.
	 */
	public Game() {
		
		// instantiate the player objects
		player1 = new HumanPlayer(this, Board.X);
		player2 = new ComputerPlayer(this, Board.O);

		// instantiate a new Board object for each new game
		this.board = new Board();

	}
	
	public Board getBoard() {
		return board;
	}
	
	/**
	 * This method takes either player object as a parameter and returns the other player object.
	 * @param player
	 * @return
	 */
	private Player otherPlayer(Player player) {
		if (player == player1) {
			return player2;
		} else {
			return player1;
		}
	}
	
	/**
	 * This method is called to play one game.
	 */
	public void play() {
		Player playerOnTheMove = player1;
		while (true) {
			Move move = playerOnTheMove.getMove();
			board.doMove(move);
			Evaluation evaluation = board.evalBoard();
			if (evaluation.isGameOver()) {
				// display the results
				System.out.println(getBoard().toString());
				System.out.println(evaluation);
				break;
			} else {
				playerOnTheMove = otherPlayer(playerOnTheMove);
			}
		}
	}

}
