
public class Ability extends Effects
	{
		protected int range;
		protected int numberOfDice;
		protected int typeOfDice;
		protected String effect;
		
		public Ability(String n, String d, String e, int r) //Used For Non damaging abilities, but has a range
		{
			range = r;
			name = n;
			description = d;
			effect = e;
		}
		
		public Ability(String n, String d, String e) //Used for Non damaging abilities
		{
			name = n;
			description = d;
			effect = e;
		}
		
		public Ability(String n, String d, String e, int r, int nd, int td)//Used for damaging abilities
		{
			range = r;
			name = n;
			description = d;
			effect = e;
			numberOfDice = nd;
			typeOfDice = td;
		}
		
		public Ability(String n, String d, String e, int nd, int td)//Used for rolling non ranged abilities
		{
			name = n;
			description = d;
			effect = e;
			numberOfDice = nd;
			typeOfDice = td;
		}
	}
