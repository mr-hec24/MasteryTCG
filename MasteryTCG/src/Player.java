import java.util.ArrayList;
import java.util.Scanner;

public class Player
	{
		protected String name;
		protected ArrayList<Card> hand = new ArrayList<Card>();
		protected Energy[] energyBar = new Energy[10];
		protected ArrayList<Card> deck;
		protected ArrayList<Card> discardPile = new ArrayList<Card>();
		protected Hero[] portal;
		protected int points;
		protected boolean isOnSideA;
		//isOnSideA should be true if that player is on the south side of the board
		
		public Player (String n, ArrayList<Card> d)
		{
			name = n;
			deck = d;
		}
		
		public void playCards(Game g)
		{
			//This is where the player can make it's moves
			TestRunner.printOut("Which Card Would You Like To Play?", 50);
			displayCurrentHand();
			Scanner userInput = new Scanner(System.in);
			int choice = userInput.nextInt();
			determineWhetherCardIsPlayable(hand.get(choice -1), g);
		}
		
		public void determineWhetherCardIsPlayable(Card c, Game g)
		{
			if (c instanceof Energy)
				{
					int freeSpace = indexOfFreeSpace(energyBar);
					if (freeSpace != -1)
						{
							energyBar[freeSpace] = (Energy)c;
							hand.remove(c);
						}
				}
			else if (c instanceof Environment)
				{
					g.playEnvironment( (Environment) c);
				}
			else if (c instanceof Hero)
				{
					if (numberOfChargedEnergy() >= ((Hero)c).level)
						{
							int[] freeSpace = indexesOfFreeSpaces(portal);
							if (freeSpace != null)
								{
									TestRunner.printOut("Where would you like to summon " + c.name + "?", 50);
									for (int i = 0; i < freeSpace.length; i++)
										{
											System.out.println("[" + i + "] - Portal " + freeSpace[i]);
										}
									// Add a scanner here so that the player can choose where to summon the hero
								}
						}
				}
		}

		public int numberOfChargedEnergy()
		{
			int numberOfChargedEnergy = 0;
			for (Energy e: energyBar)
				{
					if (e.isCharged)
						{
							numberOfChargedEnergy++;
						}
				}
			return numberOfChargedEnergy;
		}
		
		public int[] indexesOfFreeSpaces(Card[] e)
		{
			String string = "";
			int [] freeSpaces = null;
			boolean hasNoFreeSpace = true;
			for (int i = 0; i < e.length; i++)
				{
					if (e[i] == null)
						{
							string.concat(Integer.toString(i) + " ");
							hasNoFreeSpace = true;
						}
				}
			
			if (!hasNoFreeSpace)
				{
					String[] a = string.split(" ");
					freeSpaces = new int[a.length];
					int i = 0;
					for (String s: a)
						{
							freeSpaces[i] = Integer.parseInt(s);
						}
				}
			
			return freeSpaces;
		}
		
		public int indexOfFreeSpace(Card[] e)
		{
			for (int i = 0; i < e.length; i++)
				{
					if (e[i] == null)
						{
							return i;
						}
				}
			return -1;
		}
		
		public void displayCurrentHand()
		{
			int i = 1;
			for (Card c: hand)
				{
					TestRunner.printOut("[" + i + "]" + c.toString() + "\n", 25);
					i++;
				}
		}
		
		public void moveUpHeroesFromPortal(Board b)
		{
			for (int i = 0; i < portal.length; i++)
				{
					// If that portal has a Hero and the corresponding entrance to the board is empty, move up the hero
					if (portal[i] != null && (isOnSideA? b.board[b.height - 1][i] == null : b.board[0][Math.abs(i - (b.width - 1))] == null))
						{
							if (isOnSideA)
								{
									b.board[b.height - 1][i] = portal[i];
									portal[i] = null;
									TestRunner.printOut("Moved " + b.board[b.height - 1][i].name + " from the Portal to the Board!", 50);
								}
							else
								{
									b.board[0][Math.abs(i - (b.width - 1))] = portal[i];
									portal[i] = null;
								}
						}
					else if (portal[i] != null && (isOnSideA? b.board[b.height - 1][i] != null : b.board[0][Math.abs(i - (b.width - 1))] != null))
						{
							TestRunner.dramaticPrintOut("CAN'T MOVE " + portal[i].name.toUpperCase() + " BECAUSE IT'S ENTRANCE WAY IS BLOCKED BY " + (isOnSideA? b.board[b.height - 1][i].name.toUpperCase() : b.board[0][Math.abs(i - (b.width - 1))].name.toUpperCase()) + "!", 100);
						}
				}
		}
		
		public void incremementPoint(int numberOfPoints)
		{
			points += numberOfPoints;
		}
		
		public void determineSizeOfPortal(Game g)
		{
			portal = new Hero[g.board.width];
		}
		
		public void refreshEnergy()
		{
			for (Energy e: energyBar)
				{
					e.refreshEnergy();
				}
		}
		
		public void drawTopCard()
		{
			Card topCard = deck.remove(0);
			hand.add(topCard);
		}
		
		public void discardCard(Card c)
		{
			discardPile.add(c);
		}
		
		
	}
