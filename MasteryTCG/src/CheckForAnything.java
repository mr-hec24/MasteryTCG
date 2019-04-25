
public class CheckForAnything
	{
		public static void checkForEffect(Turn t, Card c)
		{
			switch (c.cardId)
			{
				case 5:	// The Researcher
						{
							break;
						}
				case 6:	// The Wanna-Be Kryptonian
						{
							break;
						}
				case 7:	// The Optimistic Sisters
						{
							break;
						}
				case 8:	// The Exploding Tennis Ball
						{
							break;
						}
				case 9:	// The Shoe Trap
						{
							Condition condition = new Condition("Shoe Trap", "Hero that landed on this Trap can't move for 2 rounds.", 4);
							t.conditions.add(condition);
							break;
						}
				case 10:// The Cholesterol Club
						{
							break;
						}
				case 11:// Amulet Of Health
						{
							break;
						}
				case 12:// Dagger
						{
							break;
						}
				case 13:// Boots Of Speed
						{
							break;
						}
				case 14:// Ray Of Frost
						{
							break;
						}
				case 15:// Fog Of Misdirection
						{
							break;
						}
				case 16:// Rain Of Arrows
						{
							break;
						}
				case 17:// Socialist Revolution
						{
							break;
						}
				case 18:// Communist Revolution
						{
							break;
						}
				case 22:// Healing Energy
						{
							break;
						}
			}
		}

		public static void putConditionInEffect()
		{
			
		}
	}
