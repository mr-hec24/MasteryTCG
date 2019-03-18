import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FillDeck
	{
		//This Method Is The Runner Of This Class
		public static Player fillDeck() throws IOException
		{
			//TestRunner.printOut("GREETINGS! WHAT IS YOUR NAME?", 50);
			
//			Scanner userInput = new Scanner (System.in);
//			String name = userInput.nextLine();
			
			//TestRunner.printOut("WELCOME, " + name.toUpperCase() + "!", 50);
			
			ArrayList<Card> deck = askUserWhichDeck();
			Player p = new Player();
			addDeckToPlayer(p, deck);
			
			return p;
		}
		
		// This method adds a deck to the player
		public static void addDeckToPlayer(Player p, ArrayList<Card> deck)
		{
			for (Card c : deck)
				{
					c.owner = p;
				}
		}
		
		/* This method asks the user whether they want to use a pre-made
		deck, or create their own. Depending on what they choose, this
		method either creates a new deck, or offers some pre-made decks*/
		public static ArrayList<Card> askUserWhichDeck() throws IOException
		{
			Scanner userInput = new Scanner(System.in);
			boolean choosing = true;
			do
				{
					TestRunner.printOut("Would you like to use one of our pre-made decks? \n[1] Yes\n[2] No", 100);
					
					int choice = userInput.nextInt();
					if (choice == 1)
						{
							return showPreMadeDecks();
						}
					else if (choice == 2)
						{
							return createDeck(createDeck());
						}
				} while (choosing);
			
			return null;
		}
		
		/* This should honestly be self explanatary.
		   This method shows the pre-made decks and
		   lets the user choose their deck to play with. */
		public static ArrayList<Card> showPreMadeDecks() throws IOException
		{
			boolean hasntChosen = true;
			do
				{
					TestRunner.printOut("Which deck would you like?\n1) BDEN's Deck\n2) Something Else", 50);
					
					Scanner userInput = new Scanner(System.in);
					int choice = userInput.nextInt();
					switch (choice)
					{
						case 1:
								{
									File f = new File ("BDEN's Deck.txt");
									return createDeck(f);
								}
						default:
								{
									TestRunner.dramaticPrintOut("DECK NOT FOUND! TRY AGAIN!", 50);
								}
					}
				} while (hasntChosen);
			
			
			return null;
		}
		
		/* This method is basically the runner of the Create
		   Your Own Deck choice. It creates a new file with
		   the temporary name of "NewDeck.txt", and it writes
		   within that file the cards that the user chooses. */
		public static File createDeck() throws IOException
		{
			TestRunner.printOut("Create your own deck.", 50);
			
			File deck = new File("NewDeck.txt");
			deck.createNewFile();
			
			return transcribeChosenCardsOntoFile(deck, chooseCards());
		}
		
		/* This method reads a file, and prints out the whole deck 
@param     File f is the File it is reading                        */
		public static void printOutFinishedDeck(File f) throws IOException
		{
			System.out.println("\n This is your deck:");
			Scanner file = new Scanner(f);
			while (file.hasNext())
				{
					int numberOfCards = file.nextInt();
					int cardId = file.nextInt();
					System.out.println(numberOfCards + "x " + Documentization.documentCards().get(cardId).name);
				}
		}
		
		/* This method takes in an ArrayList of Strings that holds the cardId's and 
		   the corresponding amount of those cards. It uses this ArrayList and just 
		   writes this information into the File f
@param     File f is the file it is writing into
@param     ArrayList<String> cards is the ArrayList it is copying into the file     */
		public static File transcribeChosenCardsOntoFile(File f, ArrayList<String> cards) throws IOException
		{
			FileOutputStream fos = new FileOutputStream(f);
			for (String data: cards)
				{
					fos.write(data.getBytes());
				}
			
			printOutFinishedDeck(f);
			return f;
		}
		
		/*	This method returns a deck that is from File f	*/
		public static ArrayList<Card> createDeck(File f) throws IOException
		{
			ArrayList<Card> deck = new ArrayList<Card>();
			Scanner file = new Scanner(f);
			while (file.hasNext())
				{
					int numberOfCards = file.nextInt();
					int cardId = file.nextInt();
					for (int i = 0; i < numberOfCards; i++)
						{
							Card card = Documentization.documentCards().get(cardId);
							if (card instanceof Energy)
								{
									deck.add(new Energy(card));
								}
							else if (card instanceof Environment)
								{
									deck.add(new Environment(card));
								}
							else if (card instanceof Hero)
								{ 
									deck.add(new Hero(card));
								}
							else if (card instanceof Item)
								{
									deck.add(new Item(card));
								}
							else if (card instanceof Spell)
								{
									deck.add(new Spell(card));
								}
							else if (card instanceof Supporter)
								{
									deck.add(new Supporter(card));
								}
							else if (card instanceof Trap)
								{
									deck.add(new Trap(card));
								}
						}
				}
			return deck;
		}
		
		/* This method is where the user chooses different cards they 
		   want to add to their deck. The chosen cards are copied to
		   an ArrayList<String>, which is returned
@return    ArrayList<String> cards, an ArrayList full of String that
		   correspond to the cards they chose and the amounts        */
		public static ArrayList<String> chooseCards()
		{
			ArrayList<String> cards = new ArrayList<String>();
			Scanner userInput = new Scanner(System.in);
			int numberOfCardsLeft = 60;
			while (numberOfCardsLeft > 0)
				{
					boolean isRealCard = false;
					int cardChoice = 0;
					while (!isRealCard)
						{
							TestRunner.printOut("Which card would you like to add to your deck? " + numberOfCardsLeft + " CARDS LEFT!", 50);
							
							showCards();
							
							TestRunner.printOut("Please type their Card Id.      " + numberOfCardsLeft + " CARDS LEFT!", 100);
							
							cardChoice = userInput.nextInt();
							try
								{
									Documentization.documentCards().get(cardChoice);
									isRealCard = true;
								}
							catch (Exception e)
								{
									TestRunner.dramaticPrintOut("THAT'S NOT A REAL CARD!", 100);
									isRealCard = false;
								}
						}
					
					int amountOfCards;
					do
						{
							TestRunner.printOut("How many copies of " + Documentization.documentCards().get(cardChoice).name + "?", 100);
							
							userInput = new Scanner(System.in);
							amountOfCards = userInput.nextInt();
						} while (Documentization.documentCards().get(cardChoice) instanceof Energy? Documentization.documentCards().get(cardChoice).name.equals("Healing Energy")? amountOfCards > 4 : amountOfCards > 10 : amountOfCards > 4);
					numberOfCardsLeft -= amountOfCards;
					

					DecimalFormat number = new DecimalFormat("000");
					String data = Integer.toString(amountOfCards) + " " + number.format(cardChoice) + "\n";
					cards.add(data);
				}
			return cards;
		}
		
		/*	This method is basically a simpler version of printing out 
			all of the documented cards in order to give the user an 
			easier time reading the information						*/
		public static void showCards()
		{
			int cardId = 0;
			for (Card c: Documentization.documentCards())
				{
					DecimalFormat number = new DecimalFormat("000");
					System.out.println("__________________________________________________________________________________________________________________________________\n");					
					System.out.printf("CARD ID: #" + number.format(cardId) + " ----- %-25s ----- ", c.name);
					System.out.print(c instanceof Hero?"HERO": c instanceof Supporter? "SUPPORTER" : c instanceof Energy? "ENERGY   " + ((Energy)c).worth : c instanceof Environment? "ENVIRONMENT" : c instanceof Item? "ITEM" : c instanceof Spell? "SPELL" : "TRAP");
					System.out.println();
					cardId++;
				}

			System.out.println("__________________________________________________________________________________________________________________________________\n");					
			System.out.println(" ");
		}
	}
