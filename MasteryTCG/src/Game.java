import java.util.ArrayList;
import java.util.Scanner;

public class Game
	{
		protected Player player1;
		protected Player player2;
		protected Board board;
		protected Environment environmentInEffect;
		protected Turn currentTurn;
		protected boolean isOver;
		
		/*	This is the constructor of a game,
		 * 	in which the user can create it's
		 * 	Players here.
		 */
		public Game(Player p1, Player p2, Board b)
		{
			//Replace the following code
			//Instead, have user create the board here,
			//and add the players here.
			player1 = p1;
			player2 = p2;
			board = b;
			environmentInEffect = null;
			currentTurn = new Turn();
			
			p1.determineSizeOfPortal(this);
			p2.determineSizeOfPortal(this);
		}
		
		/*	This method checks whether the game is over
		 * 	by checking the amount of points each player
		 * 	has. If the points are greater than or equal
		 * 	to 20, that player has won the game.
		 */
		public boolean checkIfGameIsOver()
		{
			if (player1.points >= 20)
				{
					TestRunner.dramaticPrintOut(player1.name + " HAS WON THE GAME WITH " + player1.points + "!", 50);
					return true;
				}
			else if (player2.points >= 20)
				{
					TestRunner.dramaticPrintOut(player2.name + " HAS WON THE GAME WITH " + player2.points + "!", 50);
					return true;
				}
			return false;
		}
		
		/*	This method just prints out all of the Heroes
		 * 	that a Player owns.
		 * 	@param Player p is the player it's checking for
		 * 	@return Returns an ArrayList of Heroes that are
		 * 			owned by player p
		 */
		public ArrayList<Hero> printPlayersHeroesOnBoard(Player p)
		{
			ArrayList<Hero> heroes = new ArrayList<Hero>();
			int choice = 1;
			for (Card[] row: board.board)
				{
					for (Card c: row)
						{
							if (c.owner.equals(p))
								{
									if (c instanceof Hero)
										{
											TestRunner.printOut("[" + choice + "] " + c.name + "  Speed: " + ((Hero)c).speed , 25);
											choice++;
											heroes.add((Hero)c);
										}
								}
						}
				}
			return heroes;
		}
		
		/*	This method allows the Player p to choose which
		 * 	Hero they would like to move, and where to move 
		 * 	it to
		 */
		public void moveHeroes(Player p)
		{
			boolean movingHeroes = true;
			while (movingHeroes)
				{
					TestRunner.printOut("Which Hero Would You Like To Move?", 50);
					ArrayList<Hero> heroes = printPlayersHeroesOnBoard(p);
					Scanner userInput = new Scanner(System.in);
					int choice = userInput.nextInt();
					// Finish moveHeroes method
				}
		}
		
		/*	This method goes into the nextTurn of Player
		 * 	nextPlayer. It also checks whether the game
		 * 	is over yet.
		 */
		public void nextTurn(Player nextPlayer)
		{
			if (!checkIfGameIsOver())
				{
					nextPlayer.drawCards(1);
					nextPlayer.refreshEnergy();
					nextPlayer.moveUpHeroesFromPortal(board);
					nextPlayer.playCards(this);
				}
		}
		
		/*	This method allows the Player to play an
		 * 	Environment Card. It also send the previous
		 * 	environmentInEffect to it's owner's discard
		 * 	pile.
		 */
		public void playEnvironment(Environment e)
		{
			if (environmentInEffect != null)
				{
					Player p = environmentInEffect.owner;
					p.discardPile.add(environmentInEffect);
				}
			environmentInEffect = e;
		}
	}
