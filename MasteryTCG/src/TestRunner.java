import java.io.IOException;
import java.util.ArrayList;
import java.text.*;

public class TestRunner
	{
		public static void main(String[] args) throws IOException
		{
			
			FillDeck.fillDeck();
		}
		
		public static void dramaticPrintOut(String[] message, int milliseconds) 
		{
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
		
		public static void printOut(String[] message, int milliseconds) 
			{
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
