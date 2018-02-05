import java.util.Scanner;

/**
 * This class has a main() method that you can call to play a series of Tic-Tac-Toe games.
 * Notice how it doesn't reset the Game object, but rather it makes a new Game object
 * for each new game, leaving the old game objects to be garbage collected.s
 * 
 * @author kaydell
 *
 */

public class Series {
	
	/**
	 * This Scanner object is used whenever this program reads input from the user in the console.
	 */
	static final Scanner scanner = new Scanner(System.in);

	/**
	 * This method is called to play a series of games.
	 */
	private void play() {

		// play one or more Tic-Tac-Toe games
		boolean playAgain = true;
		while (playAgain) {

			// play a new game
			Game game = new Game();
			game.play();
			
			// ask the user if they want to play again
			System.out.println("Do you want to play again? Y or N");
			String string = scanner.nextLine();
			if (string.equalsIgnoreCase("Y")) {
				playAgain = true;
			} else if (string.equalsIgnoreCase("N")) {
				playAgain = false;
			} else {
				System.out.println("Input Error: please enter either 'Y' or 'N'");
			}
			
		}
	}
	
	/**
	 * You can call this method to play a series of games.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// print a welcome message
    		System.out.println("Welcome to Tic-Tac-Toe");
    		
    		// play one or more games
    		Series series = new Series();
    		series.play();
    		
    		// print a goodbye message
    		System.out.println("Thanks for Playing Tic-Tac-Toe\n\n");

    		
    }

}
