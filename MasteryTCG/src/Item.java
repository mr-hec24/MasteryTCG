import java.util.ArrayList;
import java.awt.Image;

public class Item extends Card
	{
		protected Hero host;
		protected String effect;
		
		public Item (String n, String d, String i, String e, Hero h)
			{
				name = n;
				description = d;
				image = i;
				effect = e;
			}
	}
