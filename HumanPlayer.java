/**
 * This class is instantiated to create an object that will get moves from a human through the console.
 * 
 * @author kaydell
 *
 */
public class HumanPlayer extends Player {
	
	// constructor
	public HumanPlayer(Game game, char letter) {
		super(game, letter);
	}
	
	/**
	 * This method gets one move from the user and requires that it be a valid move.
	 */
	@Override
	public Move getMove() {
		Move move = null;
		boolean isValidMove = false;
		while (!isValidMove) {
			
			// display the board
			System.out.println(getGame().getBoard().toString()); // display the board

			// tell the user that they are going to enter a move
			System.out.println("\n" + getLetter() + "'s move");

			// let the user enter the row of the move
			System.out.println("Please enter the row.");
			String rowString = Series.scanner.nextLine();
			int row;
			try {
				row = Integer.parseInt(rowString);
				// require that the row be valid
				if (row < 1 || row > Board.SIZE) {
					System.out.println("Input Error: The row must be between 1 and " + Board.SIZE);
					continue;
				}
			} catch (NumberFormatException e){
				System.out.println("Input Error: The row must be a valid integer. " + e);
				continue;
			}
			
			// let the user enter the column of the move
			System.out.println("Please enter the column");
			String colString = Series.scanner.nextLine();
			int col;
			try {
				col = Integer.parseInt(colString);
				// require that the column be valid
				if (col < 1 || col > Board.SIZE) {
					System.out.println("Input Error: The column must be between 1 and " + Board.SIZE);
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Input Error: The row must be a valid integer." + e);
				continue;
			}

			// require that the move's square be empty
			char letter = getGame().getBoard().getLetter(row-1, col-1);
			if (letter != Board.SPACE) {
				System.out.println("Input Error: The square specified by row and column must be empty");
				continue;
			}

			// instantiate a move object
			move = new Move(getGame().getBoard(), row-1, col-1, getLetter());

			// echo the move back to the user
			System.out.println(move);

			// the move is valid
			isValidMove = true;
			
		}
		
		// move shouldn't be null at this point
		assert(move != null);

		return move;
		
	}
	
}
