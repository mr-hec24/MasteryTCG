
public class Game
	{
		protected Player player1;
		protected Player player2;
		protected Board board;
		protected Environment environmentInEffect;
		protected Turn currentTurn;
		protected boolean isOver;
		
		public Game(Player p1, Player p2, Board b)
		{
			player1 = p1;
			player2 = p2;
			board = b;
			environmentInEffect = null;
			currentTurn = new Turn();
			
			p1.determineSizeOfPortal(this);
			p2.determineSizeOfPortal(this);
		}
		
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
		
		public void nextTurn(Player nextPlayer)
		{
			if (!checkIfGameIsOver())
				{
					nextPlayer.drawTopCard();
					nextPlayer.refreshEnergy();
					nextPlayer.moveUpHeroesFromPortal(board);
					nextPlayer.playCards(this);
				}
		}
		
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
