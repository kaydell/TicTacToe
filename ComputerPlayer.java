import java.util.List;

/**
 * This class is used when you want the computer to be either or both players.
 * 
 * @author kaydell
 *
 */
public class ComputerPlayer extends Player {
	
	// constructor
	public ComputerPlayer(Game game, char letter) {
		super(game, letter);
	}

	/**
	 * This method is used to evaluate a move.  This method has the side effect of setting the evaluation field of the move object.
	 * @param board
	 * @param move
	 */
	private void evalMove(Board board, Move move) {
		
		// try the move on the board
		board.doMove(move);
		
		// do a static evaluation of the board
		Evaluation evaluation = board.evalBoard();

		// if the game is not over, keep searching for the best move
		if (!evaluation.isGameOver()) {
			Move move2 = bestMove(board, Board.otherLetter(move.getLetter()));
			evaluation = move2.getEvaluation();
		}

		// restore the board so that this method doesn't have any side-effects
		board.undoMove(move);

		// return the evaluation of the best move
		move.setEvaluation(evaluation);

	}

	/**
	 * This method returns the best move on the board by the given letter.
	 * 
	 * @param board The tic-tac-toe board
	 * @param letter The letter of the player who we are searching for the best move
	 * @return Returns the best move on the board for the player with the given letter.
	 * 
	 * This method is mutually recursive with the evalMove() method.  Together, these two
	 * methods implement a "MiniMax" algorithm.  For X, we want the maximum score and for
	 * O, we want the minimum score.  Assuming that both sides make the best move requires
	 * that sometimes we look for the highest score and other times, we look for the lowest
	 * score.
	 * 
	 * Wikipedia article on "MiniMax".
	 * https://en.wikipedia.org/wiki/Minimax
	 */
	private Move bestMove(Board board, char letter) {
		
		// generate all legal moves that can be made on the given board by the given letter
		List<Move> legalMoves = MoveGenerator.genLegalMoves(board, letter);
		
		// if there are no legal moves, return null because there is no best move
		if (legalMoves.size() <= 0) {
			return null;
		}
		
		// initialize the best move to be no move
		Move bestMove = null;

		// search for the best move
		for (Move currentMove : legalMoves) {
			evalMove(board, currentMove);
			if (bestMove == null) {
				bestMove = currentMove;
			} else if (currentMove.getEvaluation().isBetterThan(bestMove.getEvaluation(), letter)) {
				bestMove = currentMove;
			}
		}

		return bestMove;

	}

	/**
	 * This method is called to get what the computer thinks is the best move.
	 */
	@Override
	public Move getMove() {
		return bestMove(getGame().getBoard(), getLetter());
	}

}
