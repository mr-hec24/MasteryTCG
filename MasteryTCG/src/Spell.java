import java.util.ArrayList;
import java.awt.Image;

public class Spell extends Card
	{
		protected int cost;
		protected String effect;
		
		public Spell(String n, String d, String i, String e, int c)
		{
			name = n;
			description = d;
			image = i;
			effect = e;
			cost = c;
		}
	}
