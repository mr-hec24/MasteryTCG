import java.util.ArrayList;
import java.awt.Image;

public class Energy extends Card
	{
		protected int worth;
		
		public Energy(int w) 
			{
				name = "Energy";
				description = "Energy used for summoning Heroes and casting Spells";
				image = "image.jpg";
				worth = w;
			}
	}
