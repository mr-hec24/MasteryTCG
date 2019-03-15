

public class Card
	{
		protected String name;
		protected String description;
		protected String image;
		protected Player owner;
		protected int cardId;
		
		public String toString()
		{
			String s = null;
			Card c = this;
			if (c instanceof Energy)
				{
					s = ((Energy)c).name + "		Worth: " + ((Energy)c).worth + "		" + (((Energy)c).effect != null? ((Energy)c).effect : "NO EFFECT");
					return s;
				}
			else if (c instanceof Environment)
				{
					s = ((Environment)c).name + "		" + ((Environment)c).effect ;
				}
			else if (c instanceof Hero)
				{
					s = ((Hero)c).name + "  HP: " + ((Hero)c).hitpoints + "  AC: " + ((Hero)c).armorClass + "  Lvl: " + ((Hero)c).level;
				}
			else if (c instanceof Item)
				{
					s = ((Item)c).name + "  " + ((Item)c).effect;
				}
			else if (c instanceof Supporter)
				{
					s = ((Supporter)c).name + "  " + ((Supporter)c).effect;
				}
			else if (c instanceof Spell)
				{
					s = ((Spell)c).name + " Cost: " + ((Spell)c).cost + "  " + ((Spell)c).effect;
				}
			else if (c instanceof Trap)
				{
					s = ((Trap)c).name + "  " + ((Trap)c).effect;
				}
			return s;
			
		}
	}
