import java.io.*;
import java.util.Scanner;

public class FillDeck
	{
		public static void fillDeck()
		{
			
		}
		
		public static void askUserWhicDeck() throws IOException
		{
			System.out.println("Create your own deck.");
			File deck = new File("NewDeck.txt");
			System.out.println(deck.createNewFile()? "Deck has been created" : "Deck already exists");
			String fileData = "4 000";
			FileOutputStream fos = new FileOutputStream("NewDeck.txt");
			fos.write(fileData.getBytes());
			Scanner file = new Scanner(deck);
			int firstNumber = file.nextInt();
			int secondNumber = file.nextInt();
			System.out.println(firstNumber + " " + secondNumber);
		}
	}
