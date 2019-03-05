
public class Board {

	static int height = 5;
	static int width = 5;

	static Card[][] board = new Card[height][width];

	public static void addCard(Card card, int x, int y) {
		if ( board[x][y] == null) {
			board[x][y] = card;
		} 

	}

	public static Card getCards(int x, int y) {
		Card Return;
		Return = board[x][y];

		return Return;

	}

}

//FINAL PS I DIDNT TEST ANY OF THIS, IDK HOW THE REST OF YOUR TEST SOFT WORKS, SO GOOD LUCK I GUESS!
