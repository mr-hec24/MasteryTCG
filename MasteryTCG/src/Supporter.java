import java.util.ArrayList;
import java.awt.Image;

public class Supporter extends Card
	{
		protected String effect;
		
		public Supporter(String n, String d, String e, String i, int id)
		{
			name = n;
			description = d;
			effect = e;
			image = i;
			cardId = id;
		}

		public Supporter(Card c)
		{
			name = ((Supporter)c).name;
			description = ((Supporter)c).description;
			effect = ((Supporter)c).effect;
			image = ((Supporter)c).image;
			cardId = ((Supporter)c).cardId;
		}
		
		
	}
