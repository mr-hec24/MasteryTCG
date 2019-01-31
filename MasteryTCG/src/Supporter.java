import java.util.ArrayList;
import java.awt.Image;

public class Supporter extends Card
	{
		protected String effect;
		
		public Supporter(String n, String d, String e, String i)
		{
			name = n;
			description = d;
			effect = e;
			image = i;
		}

		public String getEffect()
			{
				return effect;
			}

		public void setEffect(String effect)
			{
				this.effect = effect;
			}
		
		
	}
