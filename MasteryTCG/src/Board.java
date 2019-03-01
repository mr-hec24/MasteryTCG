
public class Board {

	static int height = 5;
	static int width = 5;

	static Card[][][] board = new Card[height][width][2];

	public static void addCard(Card card, int x, int y) {
		if (card instanceof Trap == false && board[x][y][0] != null) {
			board[x][y][0] = card;
		} else if (card instanceof Trap && board[x][y][1] != null) {
			board[x][y][1] = card;

		}

	}

	public static Card[] getCards(int x, int y) {
		int state = 1;
		if (board[x][y][0] != null) {
			// if there's a Hero, *2
			state = state * 2;
		}
		if (board[x][y][1] != null) {
			// if there's a trap *3
			state = state * 3;
		}

		// heres to explain why I did that weird multiplying thing. if there's a need
		// for a third layer in the board, it will be a lot easier to make new
		// conditionals. If every condition multiplies the State by a unique prime
		// number, every combo of those conditionals will make a unique product, which
		// is easy to check for in a switch. [End gibberish]

		Card[] Return;

		// P.S. there's probably a better way to what i did here, I really didn't want
		// to
		// use one-time use vars, but whatevs :/
		switch (state) {

		case (2 * 1):
			// a Hero but no Trap
			Card[] temp = { board[x][y][0] };
			Return = temp;
			break;

		case (1 * 3):
			// a Trap but no Hero
			Card[] temp2 = { board[x][y][1] };
			Return = temp2;
			break;

		case (2 * 3):
			// both a Hero and Trap
			Card[] temp3 = { board[x][y][0], board[x][y][1] };
			Return = temp3;
			break;

		default:
			// none of the above
			Return = null;
			break;
		}

		return Return;

	}

}

//FINAL PS I DIDNT TEST ANY OF THIS, IDK HOW THE REST OF YOUR TEST SOFT WORKS, SO GOOD LUCK I GUESS!
