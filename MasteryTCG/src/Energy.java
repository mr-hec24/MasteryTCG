import java.util.ArrayList;
import java.awt.Image;

public class Energy extends Card
	{
		protected int worth;
		protected String effect;
		protected boolean isCharged = true;
		
		public Energy(int w, int id) // Normal Energy
			{
				name = "Energy";
				description = "Energy used for summoning Heroes and casting Spells";
				image = "image.jpg";
				worth = w;
				cardId = id;
			}
		
		public Energy(String n, String d, String i, int w, String e, int id) // Special Cards
		{
			name = n;
			description = d;
			image = i;
			worth = w;
			effect = e;
			cardId = id;
		}

		public Energy(Card c)
		{
			name = ((Energy)c).name;
			description = ((Energy)c).description;
			image = ((Energy)c).image;
			worth = ((Energy)c).worth;
			effect = ((Energy)c).effect;
			cardId = ((Energy)c).cardId;
		}
		
		public void refreshEnergy()
		{
			isCharged = true;
		}
		
		public void useEnergy()
		{
			isCharged = false;
		}
	}
