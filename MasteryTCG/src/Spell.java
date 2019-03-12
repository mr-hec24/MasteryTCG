import java.util.ArrayList;
import java.awt.Image;

public class Spell extends Card
	{
		protected int cost;
		protected String effect;
		
		public Spell(Card c)
		{
			name = ((Spell)c).name;
			description = ((Spell)c).description;
			image = ((Spell)c).image;
			effect = ((Spell)c).effect;
			cost = ((Spell)c).cost;
		}
		
		public Spell(String n, String d, String i, String e, int c)
		{
			name = n;
			description = d;
			image = i;
			effect = e;
			cost = c;
		}
	}
