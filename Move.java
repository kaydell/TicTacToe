/**
 * This class holds the data about a single move.  It may also hold an evaluation of that move.  The evaluation is initially null
 * but is filled in with an evaluation object when the move is evaluated elsewhere in this program.
 * 
 * @author kaydell
 *
 */
public class Move {

	// instance variables
	private Board board;
	private int row;
	private int col;
	private char letter;
	private Evaluation evaluation;
	
	// constructor
	public Move(Board board, int row, int col, char letter) {
		this.board = board;
		this.row = row;
		this.col = col;
		this.letter = letter;
		this.evaluation = null;
	}
	
	// instance methods
	
	public Board getBoard() {
		return board;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public Evaluation getEvaluation() {
		return evaluation;
	}
	
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	
	/**
	 * This method converts a Move object into a String to be printed out or viewed in the debugger.
	 */
	@Override
	public String toString() {
		return "Move: row: " + (row+1) + " col: " + (col+1) + " letter: " + letter;
	}

}
