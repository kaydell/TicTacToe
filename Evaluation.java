/**
 * This class is used to hold info about an evaluation of a board or move on the board.
 * 
 * @author kaydell
 *
 */
public class Evaluation {
	
	// constants
	public static final int TIE_GAME = 0;
	public static final int X_WON = +1;
	public static final int O_WON = -1;
	public static final boolean GAME_OVER = true;
	public static final boolean PLAYING_GAME = !GAME_OVER;
	
	// instance variables
	private int score;
	private boolean isGameOver;
	
	// constructor
	public Evaluation(int score, boolean isGameOver) {
		this.score = score;
		this.isGameOver = isGameOver;
	}
	
	// getter methods
	
	public int getScore() {
		return score;
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}
	
	/**
	 * This method is used to compare two evaluations to see which one is better for the player playing the given letter.
	 * @param that
	 * @param letter
	 * @return Returns true when "this" is better than "that".
	 */
	public boolean isBetterThan(Evaluation that, char letter) {
		if (letter == Board.X) {
			return this.score > that.score;
		} else {
			return this.score < that.score;
		}
	}
	
	/**
	 * This method converts an evaluation object to a String to either print out or to view in the debugger.
	 */
	@Override
	public String toString() {
		return (isGameOver ? "Game Over" : "Playing Game") + " " + score;
	}

}
