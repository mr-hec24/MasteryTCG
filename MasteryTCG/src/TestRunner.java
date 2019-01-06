import java.util.ArrayList;

public class TestRunner
	{
		public static void main(String[] args)
		{
			ArrayList<Card> deck = FillDeck.fillDeck();
			
			for (Card c : deck)
			{
				
				if (c instanceof Hero)
					{
						ArrayList<Effects> effects = ((Hero)c).cardAbilities;
						System.out.printf("%-20s     Hit Points: %-2d      Armor Class: %-2d", ((Hero)c).name, ((Hero)c).hitpoints, ((Hero)c).armorClass);
						System.out.printf("\nLevel %-2d                 Speed: %d            To Hit Modifier: +%-2d \n", ((Hero)c).level, ((Hero)c).speed, ((Hero)c).toHitModifier);
						System.out.printf("%-100s\n \n", ((Hero)c).description);
						for (Effects e : effects)
							{
								if (e instanceof Attack)
									{
										System.out.printf("%-20s     Range: %-2d     Damage: %2d d %-2d \n", e.name, ((Attack)e).range, ((Attack)e).numberOfDice, ((Attack)e).typeOfDice);
										System.out.printf("%-100s\n\n", e.description);
									}
								else
									{
										if (((Ability)e).typeOfDice == 0 && ((Ability)e).range == 0)
										{
											System.out.println(e.name);
											
										}
										else if (((Ability)e).typeOfDice == 0)
										{
											System.out.printf("%-20s     Range: %-2d",e.name, ((Ability)e).range);
										}
									}
							}

						System.out.println("__________________________________________________________________________________________________________________________________\n");					
						System.out.println(" ");
					}
				else
					{
						
					}
			}
		}
	}
