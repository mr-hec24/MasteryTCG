import java.io.IOException;
import java.util.ArrayList;
import java.text.*;

public class TestRunner
	{
		public static void main(String[] args)
		{
			try
				{
					FillDeck.askUserWhicDeck();
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}
		}
	}
