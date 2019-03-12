import java.util.ArrayList;
import java.awt.Image;

public class Trap extends Card
	{
		protected boolean isFaceDown;
		protected String effect;
		
		public Trap(Card c)
		{
			name = ((Trap)c).name;
			description = ((Trap)c).description;
			image = ((Trap)c).image;
			isFaceDown = ((Trap)c).isFaceDown;
			effect = ((Trap)c).effect;
		}
		
		public Trap (String n, String d, String i, String e, boolean faceDown)
		{
			name = n;
			description = d;
			image = i;
			isFaceDown = faceDown;
			effect = e;
		}
	}
