import java.io.IOException;
import java.util.ArrayList;
import java.text.*;

public class TestRunner
	{
		public static void main(String[] args) throws IOException
		{
			Player p = new Player();
			//FillDeck.fillDeck();
		}
		
		public static void dramaticPrintOut(String msg, int milliseconds) 
		{
			String[] message = msg.split("");
			for (String s: message)
				{
					try
						{
							Thread.sleep(milliseconds);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					System.out.print(s + " ");
				}
			System.out.println("");
		}
		
		public static void printOut(String msg, int milliseconds) 
			{
				String[] message = msg.split("");
				for (String s: message)
					{
						try
							{
								Thread.sleep(milliseconds);
							} catch (InterruptedException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						System.out.print(s);
					}
				System.out.println("");
			}
	}
