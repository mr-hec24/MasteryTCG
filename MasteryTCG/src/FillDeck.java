import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class FillDeck extends JFrame
	{
		private static final long serialVersionUID = 1L;
		static JFrame frame = new JFrame();
		
		//This Method Is The Runner Of This Class
		public static ArrayList<Card> fillDeck() throws IOException
		{
			ArrayList<Card> deck = askUserWhichDeck();
			
			return deck;
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
					String[] choices = {"Yes", "No"};
					JFrame frame = new JFrame();
					String choice = (String) JOptionPane.showInputDialog(frame, "Would You Like To Use One Of Our Pre-Made Decks?", "Choosing Deck", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
					
					if (choice.equals("Yes"))
						{
							return showPreMadeDecks();
						}
					else if (choice.equals("No"))
						{
							File temp = createDeck();
							renameDeck(temp);
							return createDeck(temp);
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
					String[] decks = {"BDEN's Deck"};
					JFrame frame = new JFrame();
					String choice = (String) JOptionPane.showInputDialog(frame, "Which Pre-Made Deck Would You Like?", "Choosing Deck", JOptionPane.QUESTION_MESSAGE, null, decks, decks[0]);
					
					switch (choice)
					{
						case "BDEN's Deck":
								{
									File f = new File ("BDEN's Deck.txt");
									return createDeck(f);
								}
					}
				} while (hasntChosen);
			
			
			return null;
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
							Card card = Database.documentCards().get(cardId);
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
		
		/* This method is basically the runner of the Create
		   Your Own Deck choice. It creates a new file with
		   the temporary name of "NewDeck.txt", and it writes
		   within that file the cards that the user chooses. */
		public static File createDeck() throws IOException
		{
			String[] cardChoices = new String[60];							// This String array will hold the card choices that the player chooses
			File deck = new File("NewDeck.txt");							// File in which the new deck will be held in
			deck.createNewFile();
			
			Object[] cards = Database.documentCards().toArray();		// The following Object[] holds all the possible cards the user can choose
			int[] copiesOfCards = new int[cards.length];					// The following int[] will hold the number of copies to it's corresponding card (index wise)
			for (int i = 0; i < copiesOfCards.length; i++)
				copiesOfCards[i] = 0;
			
			int cardsAvailable = 60, index = 0;								// cardsAvailable is the cards left to add in the deck; 
			while (cardsAvailable > 0)
				{
					JFrame frame = new JFrame();
					Card choice = (Card) JOptionPane.showInputDialog(frame, "Choose Cards For Your Deck \n" + cardsAvailable + " CARDS LEFT", "Creating Deck", JOptionPane.QUESTION_MESSAGE, null, cards, cards[0]);
					JOptionPane.showConfirmDialog(frame, "You Chose \"" + choice.name + "\". \n Is This Correct?");
					try
						{
							Integer[] options;
							if (choice instanceof Energy && !(choice.name.equals("Healing Energy")))
								{
									options = new Integer[10];
									for (int i = 0, j = 1; i < 10; i++, j++)
										{
											options[i] = j;
										}
								}
							else
								{
									options = new Integer[4];
									for (int i = 0, j = 1; i < 4; i++, j++)
										{
											options[i] = j;
										}
								}
							
							int numberOfCopies = (int) JOptionPane.showInputDialog(frame, "How Many Copies Of " + choice.name + " Would You Like?\n" + cardsAvailable + " CARDS LEFT", "Creating Deck", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
							JOptionPane.showConfirmDialog(frame, "You Chose " + numberOfCopies + " Copies Of " + choice.name + ".\n Is This Right?");
							
							cardsAvailable -= numberOfCopies;
							
							if ((numberOfCopies == 4 && !choice.name.equals("Energy")) || (numberOfCopies == 10 && choice.name.equals("Energy")))
									cards = removeCard(choice, cards);
							
							for (int i = 0; i < numberOfCopies; i++, index++)
								{
									cardChoices[index] = numberOfCopies + " " + choice.cardId;
								}
							
						}
					catch (Exception e)
						{
							System.out.println("Something Went Wrong...");
						}
				}
			
			
			
			return transcribeChosenCardsOntoFile(deck, cardChoices);
		}
		
		/*	This method removes a card from an array
		 * 	@param Card c is the target you want to remove
		 * 		   Object[] array is the array you want to remove it from
		 * 	@return returns a new Object[] that without Card c
		 */
		public static Object[] removeCard(Card c, Object[] array)
		{
			Object[] newArray = new Object[array.length - 1];
			
			for (int i = 0, index = 0; i < array.length; i++)
				{
					if (!array[i].equals(c))
						{
							newArray[index] = array[i];
							index++;
						}
				}
			
			return newArray;
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
					System.out.println(numberOfCards + "x " + Database.documentCards().get(cardId).name);
				}
		}
		
		/* This method takes in an ArrayList of Strings that holds the cardId's and 
		   the corresponding amount of those cards. It uses this ArrayList and just 
		   writes this information into the File f
@param     File f is the file it is writing into
@param     ArrayList<String> cards is the ArrayList it is copying into the file     */
		public static File transcribeChosenCardsOntoFile(File f, String[] cards) throws IOException
		{
			FileOutputStream fos = new FileOutputStream(f);
			for (String data: cards)
				{
					fos.write(data.getBytes());
				}
			
			printOutFinishedDeck(f);
			return f;
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
									Database.documentCards().get(cardChoice);
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
							TestRunner.printOut("How many copies of " + Database.documentCards().get(cardChoice).name + "?", 100);
							
							userInput = new Scanner(System.in);
							amountOfCards = userInput.nextInt();
						} while (Database.documentCards().get(cardChoice) instanceof Energy? Database.documentCards().get(cardChoice).name.equals("Healing Energy")? amountOfCards > 4 : amountOfCards > 10 : amountOfCards > 4);
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
			for (Card c: Database.documentCards())
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
	
		public static void renameDeck(File f)
		{
			String name = JOptionPane.showInputDialog("What Would You Like To Name Your Deck?", "Input Name Here (Dont Include .txt)");
			File temp = new File(name + ".txt");
			boolean b = f.renameTo(temp);
			if (b)
				b = temp.delete();
		}
	
	}
