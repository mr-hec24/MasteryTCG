import java.util.ArrayList;
import java.awt.Image;

public class Environment extends Card
	{
		protected String effect;
		
		public Environment(String n, String d, String i, String e, int id)
		{
			name = n;
			description = d;
			image = i;
			effect = e;
			cardId = id;
		}

		public Environment(Card c)
		{
			name = ((Environment)c).name;
			description = ((Environment)c).description;
			image = ((Environment)c).image;
			effect = ((Environment)c).effect;
			cardId = ((Environment)c).cardId;
		}
	}
