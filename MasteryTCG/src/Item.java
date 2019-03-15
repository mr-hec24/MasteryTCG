import java.util.ArrayList;
import java.awt.Image;

public class Item extends Card
	{
		protected Hero host;
		protected String effect;
		
		public Item (String n, String d, String i, String e, int id)
		{
			name = n;
			description = d;
			image = i;
			effect = e;
			host = null;
			cardId = id;
		}

		public Item(Card c)
		{
			name = ((Item)c).name;
			description = ((Item)c).description;
			image = ((Item)c).image;
			effect = ((Item)c).effect;
			host = ((Item)c).host;
			cardId = ((Item)c).cardId;
		}
	}
