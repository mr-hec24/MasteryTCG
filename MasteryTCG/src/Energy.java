import java.util.ArrayList;
import java.awt.Image;

public class Energy extends Card
	{
		protected int worth;
		protected String effect;
		
		public Energy(int w) // Normal Energy
			{
				name = "Energy";
				description = "Energy used for summoning Heroes and casting Spells";
				image = "image.jpg";
				worth = w;
			}
		
		public Energy(String n, String d, String i, int w, String e) // Special Cards
		{
			name = n;
			description = d;
			image = i;
			worth = w;
			effect = e;
		}
	}
