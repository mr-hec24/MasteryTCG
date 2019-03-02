import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FillDeck
	{
		public static void fillDeck()
		{
			
		}
		
		/* This method asks the user whether they want to use a pre-made
		deck, or create their own. Depending on what they choose, this
		method either creates a new deck, or offers some pre-made decks*/
		public static void askUserWhicDeck() throws IOException
		{
			Scanner userInput = new Scanner(System.in);
			boolean choosing = true;
			do
				{
					System.out.println("Would you like to use one of our pre-made decks?");
					System.out.println("[1] Yes\n[2] No");
					int choice = userInput.nextInt();
					if (choice == 1)
						{
							showPreMadeDecks();
							choosing = false;
						}
					else if (choice == 2)
						{
							createDeck();
							choosing = false;
						}
				} while (choosing);
			
			
		}
		
		/* This should honestly be self explanatary.
		   This method shows the pre-made decks and
		   lets the user choose their deck to play with. */
		public static void showPreMadeDecks()
		{
			
		}
		
		/* This method is basically the runner of the Create
		   Your Own Deck choice. It creates a new file with
		   the temporary name of "NewDeck.txt", and it writes
		   within that file the cards that the user chooses. */
		public static void createDeck() throws IOException
		{
			
			System.out.println("Create your own deck.");
			File deck = new File("NewDeck.txt");
			deck.createNewFile();
			
			transcribeChosenCardsOntoFile(deck, chooseCards());
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
		public static void transcribeChosenCardsOntoFile(File f, ArrayList<String> cards) throws IOException
		{
			FileOutputStream fos = new FileOutputStream(f);
			for (String data: cards)
				{
					fos.write(data.getBytes());
				}
			
			printOutFinishedDeck(f);
			
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
			int numberOfCardsLeft = 30;
			while (numberOfCardsLeft > 0)
				{
					boolean isRealCard = false;
					int cardChoice = 0;
					while (!isRealCard)
						{
							System.out.println("Which card would you like to add to your deck? " + numberOfCardsLeft + " CARDS LEFT!");
							showCards();
							System.out.println("Please type their Card Id.      " + numberOfCardsLeft + " CARDS LEFT!");
							cardChoice = userInput.nextInt();
							try
								{
									Documentization.documentCards().get(cardChoice);
									isRealCard = true;
								}
							catch (Exception e)
								{
									System.out.println("THAT'S NOT A REAL CARD!");
									isRealCard = false;
								}
						}
					
					int amountOfCards;
					do
						{
							System.out.println("How many copies of " + Documentization.documentCards().get(cardChoice).name + "?");
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