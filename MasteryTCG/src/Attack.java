
public class Attack extends Effects
	{
		protected int range;
		protected int numberOfDice;
		protected int typeOfDice;
		protected String effect;
		
		public Attack (String n, String d, int r, int nod, int tod) //Attack without effect
		{
			name = n;
			description = d;
			range = r;
			numberOfDice = nod;
			typeOfDice = tod;
		}
		
		public Attack(String n, String d, String e, int r, int nod, int tod) // Attack that also has an effect
		{
				name = n;
				description = d;
				effect = e;
				range = r;
				numberOfDice = nod;
				typeOfDice = tod;
		}
		
		public int damage()
		{
			int damage = 0;
			for (int i = 0; i < numberOfDice; i++)
				damage += (int)(Math.random()*typeOfDice) + 1;
			
			return damage;
		}
		
	}
