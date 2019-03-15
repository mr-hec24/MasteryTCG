
public class Board {

	protected int height;
	protected int width;
	protected Card[][] board;
	
	public Board(int height, int width) {
		board = new Card[height][width];

	}
	
	

	public Card[][] getBoard() {
		return board;
	}


	public void addCard(Card card, int x, int y) 
	{
	if ( board[x][y] == null) 
		{	
			board[x][y] = card;
		} 

	}

	public Card getCards(int x, int y) 
	{
		Card Return;
		Return = board[x][y];

		return Return;
	}

	
	public void moveCard(int x, int y, int moveX, int moveY) {
		
		//X, Y are the coordinates of the card being moved
		//the moveX , moveY variables say which direction to move,
		//+x moves forward -x moves backward
		//+y moves right, -y moves left
		
		Card currentCard = this.board[x][y];
		boolean isOnSideA = currentCard.owner.isOnSideA;
		
		//adjust the move variables
		if(isOnSideA) {
			moveX = moveX*-1;
			moveY = moveY*-1;
		}
		
		//check to make sure the tile moving to is empty
		if(this.board[x+moveX][y+moveY]==null) {
			this.board[x+moveX][y+moveY] = this.board[x][y];
			this.board[x][y] = null;
			
		}
		
		 
		
		
	}
	
}

//FINAL PS I DIDNT TEST ANY OF THIS, IDK HOW THE REST OF YOUR TEST SOFT WORKS, SO GOOD LUCK I GUESS!
