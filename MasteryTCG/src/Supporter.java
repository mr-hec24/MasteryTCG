import java.util.ArrayList;
import java.awt.Image;

public class Supporter extends Card
	{
		protected String effect;
		
		public Supporter(Card c)
		{
			name = ((Supporter)c).name;
			description = ((Supporter)c).description;
			effect = ((Supporter)c).effect;
			image = ((Supporter)c).image;
		}
		
		public Supporter(String n, String d, String e, String i)
		{
			name = n;
			description = d;
			effect = e;
			image = i;
		}
		
		
	}
