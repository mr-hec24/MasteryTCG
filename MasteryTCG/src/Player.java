import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.*;

public class Player
	{
		/* This little enum is just a set of constants of
		 * actions that you can do per turn
		 */
		enum Action
		{
			PLAY_CARD, MOVE_HEROES, ATTACK, USE_ABILITY 
		}
		protected String name;
		protected ArrayList<Card> hand = new ArrayList<Card>();
		protected Energy[] energyBar = new Energy[10];
		protected ArrayList<Card> deck;
		protected ArrayList<Card> discardPile = new ArrayList<Card>();
		protected Hero[] portal;
		protected int points;
		protected boolean isOnSideA;
		protected Scanner userInput = new Scanner(System.in);
		static JFrame frame = new JFrame();
		//isOnSideA should be true if that player is on the south side of the board
		
		public Player () throws IOException
		{
			name = JOptionPane.showInputDialog("What Is Your Name?", "Input Name Here");
			JOptionPane.showMessageDialog(frame, "Welcome, " + name);
			hand = new ArrayList<Card>();
			energyBar = new Energy[10];
			deck = FillDeck.fillDeck();
			discardPile = new ArrayList<Card>();
//			isOnSideA = ;	isOnSideA also depends on the Board??
		}
		
		/*	This method is the basic layout of what a player
		 *	can do on it's turn.
		 *	@param Game g is the game this player is currently in
		 */	
		public void playGame(Game g)
		{
			boolean playingTurn = true;
			while (playingTurn)
				{
					TestRunner.printOut("What Would You Like To Do?\n[1] " + Action.PLAY_CARD + "\n[2] " + Action.MOVE_HEROES + "\n[3] " + Action.ATTACK + "\n[4] " + Action.USE_ABILITY, 50);
					int choice = userInput.nextInt();
					switch (choice)
					{
						case 1:
								{
									playCards(g);
									break;
								}
						case 2:
								{
									g.moveHeroes(this);
									break;
								}
						case 3:
								{
									break;
								}
						case 4:
								{
									break;
								}
						default:
								{
									TestRunner.dramaticPrintOut("DID NOT UNDERSTAND WHAT YOU WANTED TO DO", 50);
									break;
								}
					}
				}
		}
		
		public void playCards(Game g)
		{
			boolean playingCards = true;
			while (playingCards)
				{
					TestRunner.printOut("Which Card Would You Like To Play?", 50);
					displayCurrentHand();
					Scanner userInput = new Scanner(System.in);
					int choice = userInput.nextInt();
					determineWhetherCardIsPlayable(hand.get(choice - 1), g);
					
					TestRunner.printOut("Would You Like To Play Another Card?\n[1] Yes\n[2] No", 50);
					userInput = new Scanner (System.in);
					choice = userInput.nextInt();
					playingCards = choice == 1? true : false;
				}
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
					else
						TestRunner.dramaticPrintOut("CAN'T PLAY ANYMORE ENERGY", 50);
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
									for (int i = 0, choice = 1; i < freeSpace.length; i++, choice++)
										{
											System.out.println("[" + choice + "] - Portal " + freeSpace[i]);
										}
									Scanner userInput = new Scanner(System.in);
									int choice = userInput.nextInt();
									TestRunner.printOut("Summoning Hero...", 50);
									portal[freeSpace[choice - 1]] = (Hero) c;
									hand.remove(c);
									for (int i = indexOfChargedEnergy(), j = 0; j < ((Hero)c).level; i++, j++)
										{
											energyBar[i].isCharged = false;
										}
								}
							else
								TestRunner.dramaticPrintOut("NO AVAILABLE PORTALS FOR " + c.name.toUpperCase(), 50);
						}
					else
						TestRunner.dramaticPrintOut("NOT ENOUGH CHARGED ENERGY FOR " + c.name.toUpperCase(), 50);
						
				}
			else if (c instanceof Item)
				{
					boolean availableHero = false;
					int option = 1;
					ArrayList<Integer> indexes = new ArrayList<Integer>();
					for (int i = 0; i < portal.length; i++)
						{
							if (portal[i] != null && portal[i].item == null)
								{
									availableHero = true;
									TestRunner.printOut("[" + option + "]" + portal[i].name, 25);
									option++;
									indexes.add(i);
								}
						}
					TestRunner.printOut("Which Hero would you like to attach " + c.name + " to?", 25);
					Scanner userInput = new Scanner(System.in);
					int choice = userInput.nextInt();
					TestRunner.printOut("Attaching Item...", 50);
					portal[indexes.get(choice - 1)].attatchItem((Item) c);
					hand.remove(c);
					
					if (availableHero == false)
						{
							TestRunner.dramaticPrintOut("NO AVAILABLE HERO TO ATTACH ITEM TO", 50);
						}
				}
			else if (c instanceof Supporter)
				{
					CheckForAnything.checkForEffect(g.currentTurn, c);
				}
			else if (c instanceof Spell)
				{
					if (numberOfChargedEnergy() >= ((Spell)c).cost)
						{
							CheckForAnything.checkForEffect(g.currentTurn, c);
							for (int i = indexOfChargedEnergy(), j = 0; j < ((Spell)c).cost; i++, j++)
								{
									energyBar[i].isCharged = false;
								}
						}
					else
						TestRunner.dramaticPrintOut("NOT ENOUGH CHARGED ENERGY TO CAST " + c.name.toUpperCase(), 50);
				}
			else if (c instanceof Trap)
				{
					TestRunner.dramaticPrintOut("CAN'T PLACE DOWN A TRAP UNLESS YOU MOVED A HERO", 50);
				}
		}

		public int indexOfChargedEnergy()
		{
			int index = 0;
			for (Energy e: energyBar)
				{
					if (e.isCharged)
						{
							return index;
						}
					index++;
				}
			index = -1;
			return index;
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
		
		/*	This little method basically makes energy
		 * 	available to use 
		 */
		public void refreshEnergy()
		{
			for (Energy e: energyBar)
				{
					e.refreshEnergy();
				}
		}
		
		/*	This little method should be self explanatory
		 * 	but just in case, it draws i cards from the deck
		 * 	and adds it to your hand, removing it from deck
		 * 	@param int i is how many Cards you wanna draw
		 */	
		public void drawCards(int i)
		{
			for (int j = 0; j < i; j++)
				{
					Card topCard = deck.remove(0);
					hand.add(topCard);
				}
		}
		
		/*	This little method should be self explanatory
		 * 	but just in case, it discards a card from the hand
		 * 	@param Card c is the Card that is discarded
		 */
		public void discardCard(Card c)
		{
			discardPile.add(c);
			hand.remove(c);
		}
		
		
	}
