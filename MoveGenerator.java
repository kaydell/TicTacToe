import java.util.List;
import java.util.ArrayList;

/**
 * This class is used  to generate all of the legal moves that can be made by the player playing the given letter.
 * @author kaydell
 *
 */
public class MoveGenerator {
	
	/**
	 * This method returns a list of all legal moves
	 * 
	 * @param board The board that the legal moves can be made on.
	 * @param letter1 The letter of the player that can make the moves
	 * @return Returns the list of legal moves on the board for the given letter.
	 */
	public static List<Move> genLegalMoves(Board board, char letter1) {
		List<Move> legalMoves = new ArrayList<Move>();
		for (int row = 0; row < Board.SIZE; row++) {
			for (int col = 0; col < Board.SIZE; col++) {
				char letter2 = board.getLetter(row, col);
				if (letter2 == Board.SPACE) {
					Move move = new Move(board, row, col, letter1);
					legalMoves.add(move);
				}
			}
		}
		return legalMoves;
	}

}
