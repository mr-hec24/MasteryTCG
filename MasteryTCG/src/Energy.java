import java.util.ArrayList;
import java.awt.Image;

public class Energy extends Card
	{
		protected int worth;
		protected String effect;
		
		public Energy (Card c)
		{
			name = ((Energy)c).name;
			description = ((Energy)c).description;
			image = ((Energy)c).image;
			worth = ((Energy)c).worth;
			effect = ((Energy)c).effect;
		}
		
		public Energy(String n, int w) // Normal Energy
			{
				name = n;
				description = "Energy used for summoning Heroes and casting Spells";
				image = "image.jpg";
				worth = w;
				effect = null;
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
