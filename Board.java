/**
 * This class contains the code that implements a Tic-Tac-Toe board. 
 */
public class Board {

	// constants

	/**
	 * The space character is the letter stored for empty squares on the board.
	 */
	public static final char SPACE = ' ';
	
	public static final char X = 'X';
	public static final char O = 'O';

	/**
	 *  The number of rows and columns in the board
	 */
	public static final int SIZE = 3;

	// static  methods

	/**
	 * This method takes either 'X' or 'O' as a parameter and returns the other character.
	 * @param letter The letter 'X' or 'O'
	 * @return Returns the opposite letter.
	 */
	public static char otherLetter(char letter) {
		switch (letter) {
		case X:
			return O;
		case O:
			return X;
		default:
			assert(false);
			return 'E';
		}
	}
	
	// instance variables

	/**
	 *  The array that contains the letters
	 */
	private char[][] letters = new char[SIZE][SIZE];
	
	// constructor
	public Board() {
		// default the letters to be spaces instead of being null characters
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				letters[row][col] = SPACE;
			}
		}
	}

	/**
	 * This method is used to retrieve letters from the board
	 * @param row The row of the board for the Letter to be retrieved
	 * @param col The column of the board for the Letter to be retrieved
	 * @return Returns the letter in the square specified by the row and col parameters.  Either 'X', 'O', or SPACE
	 */
	public char getLetter(int row, int col) {
		return letters[row][col];
	}

	/**
	 * This method is called to determine whether the board is full or not.  If it is full
	 * then it is a tie game, unless there is three-in-a-row.
	 * @return Returns true when all squares have pieces in them, otherwise returns false.
	 */
	boolean isBoardFull() {
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				boolean isSquareEmpty = getLetter(row, col) == SPACE;
				if (isSquareEmpty) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method accepts 4 letters and returns true if they are all the same.
	 * @param letter1
	 * @param letter2
	 * @param letter3
	 * @param letter4
	 * @return Returns true if all of the parameters are equal.
	 */
	private boolean sameLetter(char letter1, char letter2, char letter3, char letter4) {
		return letter1 == letter2 &&
			   letter1 == letter3 &&
			   letter1 == letter4;
	}
	
	/**
	 * This method returns true if there is a win in any row by the given letter.
	 * @param letter The letter that we are checking for a win.
	 * @return Returns true when there is three-in-a-row in any row of the given letter
	 */
	private boolean winInRows(char letter) {
		return sameLetter(letter, getLetter(0,0), getLetter(1,0), getLetter(2,0)) ||
			   sameLetter(letter, getLetter(0,1), getLetter(1,1), getLetter(2,1)) ||
			   sameLetter(letter, getLetter(0,2), getLetter(1,2), getLetter(2,2));
	}

	/**
	 * This method returns true when there is a win in any column by the player playing the given letter
	 * @param letter The letter to use to search for a win.
	 * @return Returns true when there is a three-in-a-row win in any column by the player with the given letter.
	 */
	private boolean winInCols(char letter) {
		return sameLetter(letter, getLetter(0,0), getLetter(0,1), getLetter(0,2)) ||
			   sameLetter(letter, getLetter(1,0), getLetter(1,1), getLetter(1,2)) ||
			   sameLetter(letter, getLetter(2,0), getLetter(2,1), getLetter(2,2));
	}

	/**
	 * This method returns true when there is a win on either diagonal by the player playing the given letter.
	 * @param letter
	 * @return
	 */
	private boolean winInDiagonals(char letter) {
		return sameLetter(letter, getLetter(0,0), getLetter(1,1), getLetter(2,2)) ||
			   sameLetter(letter, getLetter(0,2), getLetter(1,1), getLetter(2,0));
	}

	/**
	 * This method returns true when there is any win by the player playing the given letter.
	 * @param letter
	 * @return
	 */
	boolean threeInARow(char letter) {
		return winInRows(letter) || winInCols(letter) || winInDiagonals(letter);
	}
	
	/**
	 * This method makes a move on the board.
	 * @param move The move to make on the board
	 */
	public void doMove(Move move) {
		letters[move.getRow()][move.getCol()] = move.getLetter();		
	}
	
	/**
	 * This method undoes a move that was done by the doMove() method.
	 * @param move
	 */
	public void undoMove(Move move) {
		letters[move.getRow()][move.getCol()] = SPACE;		
	}

	/**
	 * This method is used to evaluate a board.  This evaluation is static, meaning that there is no look-ahead.
	 * @return Returns an Evaluation object.
	 */
	Evaluation evalBoard() {
		if (threeInARow(X)) {
			return new Evaluation(Evaluation.X_WON, Evaluation.GAME_OVER);
		} else if (threeInARow(O)) {
			return new Evaluation(Evaluation.O_WON, Evaluation.GAME_OVER);
		} else if (isBoardFull()) {
				return new Evaluation(Evaluation.TIE_GAME, Evaluation.GAME_OVER);
		} else {
			return new Evaluation(Evaluation.TIE_GAME, Evaluation.PLAYING_GAME);
		}
	}
    
    /**
     * This method converts a Board object to a String object to be printed for the user 
     * or viewed in the debugger so that humans can see the Tic-Tac-Toe board that Java has
     * as objects.
     */
    @Override
    public String toString() {
    		// instantiate a StringBuilder object to gather the String that is displayed for the board
    		StringBuilder sb = new StringBuilder();
    		// column numbers
    		sb.append("\n   1   2   3\n");
    		for (int row = 0; row < SIZE; row++) {
    			sb.append("\n" + (row+1) + "  ");
    			for (int col = 0; col < SIZE; col++) {
    				char letter = getLetter(row, col);
    				sb.append(letter);
    				sb.append("   ");
    			}
    			sb.append("\n");
    		}
    		// convert the StringBuilder to a String
    		String string = sb.toString();
    		
    		return string;
    		
    }

}