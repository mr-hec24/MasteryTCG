import java.util.ArrayList;

public class Player
	{
		protected String name;
		protected ArrayList<Card> hand = new ArrayList<Card>();
		protected Card[] energyBar = new Card[10];
		protected ArrayList<Card> deck;
		protected ArrayList<Card> discardPile = new ArrayList<Card>();
		protected boolean isOnSideA;
		//isOnSideA should be true if that player is on the south side of the board
		
		public Player (String n, ArrayList<Card> d)
		{
			name = n;
			deck = d;
		}
		
		public void discardCard(Card c)
		{
			discardPile.add(c);
		}
		
		
	}
